package br.com.gustavo.nexafood.service;

import br.com.gustavo.nexafood.dto.RestauranteRequestDTO;
import br.com.gustavo.nexafood.dto.RestauranteResponseDTO;
import br.com.gustavo.nexafood.model.Restaurante;
import br.com.gustavo.nexafood.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RestauranteService {

  @Autowired
  private RestauranteRepository restauranteRepository;

  // O método agora recebe um DTO, mas salva uma Entidade
  public RestauranteResponseDTO criarRestaurante(RestauranteRequestDTO requestDTO) {
    // 1. Converte o DTO de requisição para uma Entidade
    Restaurante restaurante = new Restaurante();
    restaurante.setNome(requestDTO.getNome());
    restaurante.setCnpj(requestDTO.getCnpj());

    // 2. Salva a Entidade no banco
    Restaurante restauranteSalvo = restauranteRepository.save(restaurante);

    // 3. Converte a Entidade salva para um DTO de resposta e retorna
    return new RestauranteResponseDTO(restauranteSalvo);
  }

  // O método agora retorna uma lista de DTOs
  public List<RestauranteResponseDTO> listarTodos() {
    return restauranteRepository.findAll()
        .stream() // Transforma a lista em um fluxo de dados
        .map(RestauranteResponseDTO::new) // Para cada item, cria um novo DTO
        .collect(Collectors.toList()); // Coleta os DTOs em uma nova lista
  }

  // O método agora retorna um Optional de DTO
  public Optional<RestauranteResponseDTO> buscarPorId(UUID id) {
    return restauranteRepository.findById(id)
        .map(RestauranteResponseDTO::new); // Se o Optional contiver algo, converte para DTO
  }

  // O método agora recebe um DTO para os dados atualizados
  public Optional<RestauranteResponseDTO> atualizar(UUID id, RestauranteRequestDTO dadosAtualizados) {
    Optional<Restaurante> restauranteOptional = restauranteRepository.findById(id);

    if (restauranteOptional.isPresent()) {
      Restaurante restauranteExistente = restauranteOptional.get();
      restauranteExistente.setNome(dadosAtualizados.getNome());
      restauranteExistente.setCnpj(dadosAtualizados.getCnpj());

      Restaurante restauranteAtualizado = restauranteRepository.save(restauranteExistente);
      return Optional.of(new RestauranteResponseDTO(restauranteAtualizado));
    } else {
      return Optional.empty();
    }
  }

  // Novo método para deletar um restaurante
  public boolean deletar(UUID id) {
    // O método existsById é mais eficiente do que o findById para apenas verificar
    // a existência.
    if (restauranteRepository.existsById(id)) {
      restauranteRepository.deleteById(id);
      return true; // Retorna true se o restaurante foi encontrado e deletado.
    }
    return false; // Retorna false se o restaurante não foi encontrado.
  }
}