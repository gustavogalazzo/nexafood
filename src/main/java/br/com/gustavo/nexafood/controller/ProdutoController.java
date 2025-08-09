package br.com.gustavo.nexafood.controller;

import br.com.gustavo.nexafood.dto.ProdutoRequestDTO;
import br.com.gustavo.nexafood.dto.ProdutoResponseDTO;
import br.com.gustavo.nexafood.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
// A URL base agora é mais complexa, pois depende do restaurante
@RequestMapping("/api/restaurantes/{restauranteId}/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoService produtoService;

  @PostMapping
  public ResponseEntity<ProdutoResponseDTO> criarProduto(
      @PathVariable UUID restauranteId,
      @RequestBody ProdutoRequestDTO produtoDTO) {

    ProdutoResponseDTO novoProduto = produtoService.criarProduto(restauranteId, produtoDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
  }
}