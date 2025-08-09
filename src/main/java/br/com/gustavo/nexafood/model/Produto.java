package br.com.gustavo.nexafood.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "produtos")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private String nome;

  private String descricao;

  @Column(nullable = false)
  private BigDecimal preco;

  private boolean disponivel = true;

  // NOVO RELACIONAMENTO: Muitos Produtos para Um Restaurante
  @ManyToOne
  @JoinColumn(name = "restaurante_id", nullable = false)
  private Restaurante restaurante;
}