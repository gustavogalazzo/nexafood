package br.com.gustavo.nexafood.service;

import br.com.gustavo.nexafood.dto.ProdutoRequestDTO;
import br.com.gustavo.nexafood.dto.ProdutoResponseDTO;
import br.com.gustavo.nexafood.model.Produto;
import br.com.gustavo.nexafood.model.Restaurante;
import br.com.gustavo.nexafood.repository.ProdutoRepository;
import br.com.gustavo.nexafood.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.UUID;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private RestauranteRepository restauranteRepository;

  public ProdutoResponseDTO criarProduto(UUID restauranteId, ProdutoRequestDTO requestDTO) {
    Restaurante restaurante = restauranteRepository.findById(restauranteId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado"));

    Produto produto = new Produto();
    produto.setNome(requestDTO.getNome());
    produto.setDescricao(requestDTO.getDescricao());
    produto.setPreco(requestDTO.getPreco());
    produto.setRestaurante(restaurante); // <-- A MÁGICA DO RELACIONAMENTO

    Produto produtoSalvo = produtoRepository.save(produto);

    return new ProdutoResponseDTO(produtoSalvo);
  }

  // Faremos os outros métodos do CRUD (listar, atualizar, deletar) aqui depois...
}