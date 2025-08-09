package br.com.gustavo.nexafood.dto;

import lombok.Data;

// Não tem anotações de @Entity, pois não é uma tabela.
// É apenas um "saco de dados" simples.
@Data
public class RestauranteRequestDTO {
  private String nome;
  private String cnpj;
}