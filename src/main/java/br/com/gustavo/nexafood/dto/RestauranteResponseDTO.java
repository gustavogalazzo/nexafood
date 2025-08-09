package br.com.gustavo.nexafood.dto;

import br.com.gustavo.nexafood.model.Restaurante;
import lombok.Data;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class RestauranteResponseDTO {
  private UUID id;
  private String nome;
  private String cnpj;
  private List<ProdutoResponseDTO> produtos; // <- NOVA LINHA

  public RestauranteResponseDTO(Restaurante restaurante) {
    this.id = restaurante.getId();
    this.nome = restaurante.getNome();
    this.cnpj = restaurante.getCnpj();
    // Transforma a lista de Entidades Produto em uma lista de DTOs Produto
    this.produtos = restaurante.getProdutos().stream() // <- NOVO BLOCO
        .map(ProdutoResponseDTO::new)
        .collect(Collectors.toList());
  }
}