package br.com.gustavo.nexafood.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// @Data: Anotação do Lombok. Ela cria automaticamente em tempo de compilação
// os métodos getters, setters, equals, hashCode e toString. Economiza muito código!
@Data

// @Entity: Anotação do JPA (Java Persistence API). Informa ao Spring que esta
// classe representa uma tabela no banco de dados.
@Entity

// @Table: Especifica o nome exato da tabela no banco. É uma boa prática usar
// nomes no plural e em minúsculas para tabelas.
@Table(name = "restaurantes")

public class Restaurante {

  // @Id: Marca este campo como a chave primária (Primary Key) da tabela.
  @Id

  // @GeneratedValue: Informa como o valor do ID será gerado. GenerationType.AUTO
  // é uma estratégia flexível que funciona bem com UUIDs.
  @GeneratedValue(strategy = GenerationType.AUTO)

  private UUID id;

  // @Column: Permite customizar a coluna no banco de dados.
  // unique = true: Garante que não haverá dois restaurantes com o mesmo nome.
  // nullable = false: Garante que este campo nunca poderá ser nulo no banco.
  @Column(unique = true, nullable = false)
  private String nome;

  // length = 14: Define o tamanho máximo do campo no banco.
  @Column(unique = true, nullable = false, length = 14)
  private String cnpj;

  // NOVO RELACIONAMENTO: Um Restaurante para Muitos Produtos
  @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Produto> produtos = new ArrayList<>();
}
