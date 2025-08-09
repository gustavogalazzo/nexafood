package br.com.gustavo.nexafood.controller;

import br.com.gustavo.nexafood.dto.RestauranteRequestDTO;
import br.com.gustavo.nexafood.dto.RestauranteResponseDTO;
import br.com.gustavo.nexafood.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

  @Autowired
  private RestauranteService restauranteService;

  // Agora recebe RequestDTO e retorna ResponseDTO
  @PostMapping
  public ResponseEntity<RestauranteResponseDTO> criarRestaurante(@RequestBody RestauranteRequestDTO restauranteDTO) {
    RestauranteResponseDTO novoRestaurante = restauranteService.criarRestaurante(restauranteDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(novoRestaurante);
  }

  // Agora retorna uma lista de ResponseDTO
  @GetMapping
  public ResponseEntity<List<RestauranteResponseDTO>> listarTodos() {
    List<RestauranteResponseDTO> restaurantes = restauranteService.listarTodos();
    return ResponseEntity.ok(restaurantes);
  }

  // Agora retorna um ResponseDTO
  @GetMapping("/{id}")
  public ResponseEntity<RestauranteResponseDTO> buscarPorId(@PathVariable UUID id) {
    Optional<RestauranteResponseDTO> restauranteOptional = restauranteService.buscarPorId(id);
    if (restauranteOptional.isPresent()) {
      return ResponseEntity.ok(restauranteOptional.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // Agora recebe RequestDTO e retorna ResponseDTO
  @PutMapping("/{id}")
  public ResponseEntity<RestauranteResponseDTO> atualizar(@PathVariable UUID id,
      @RequestBody RestauranteRequestDTO restauranteDTO) {
    Optional<RestauranteResponseDTO> restauranteAtualizado = restauranteService.atualizar(id, restauranteDTO);

    if (restauranteAtualizado.isPresent()) {
      return ResponseEntity.ok(restauranteAtualizado.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable UUID id) {
    boolean deletado = restauranteService.deletar(id);

    if (deletado) {
      // Retorna 204 No Content, o status padrão para uma exclusão bem-sucedida.
      return ResponseEntity.noContent().build();
    } else {
      // Retorna 404 Not Found se o restaurante não existia.
      return ResponseEntity.notFound().build();
    }
  }
}