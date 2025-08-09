package br.com.gustavo.nexafood.dto;

import br.com.gustavo.nexafood.model.Produto;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProdutoResponseDTO {
  private UUID id;
  private String nome;
  private String descricao;
  private BigDecimal preco;

  public ProdutoResponseDTO(Produto produto) {
    this.id = produto.getId();
    this.nome = produto.getNome();
    this.descricao = produto.getDescricao();
    this.preco = produto.getPreco();
  }
}