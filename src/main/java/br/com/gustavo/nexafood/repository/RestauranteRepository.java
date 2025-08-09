package br.com.gustavo.nexafood.repository;

import br.com.gustavo.nexafood.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

// Ao estender JpaRepository, nós ganhamos de graça uma imensidão de métodos
// para interagir com o banco de dados, como save(), findById(), findAll(), etc.
// Nós informamos que este repositório gerencia a entidade <Restaurante>
// e que o tipo da chave primária dessa entidade é <UUID>.
public interface RestauranteRepository extends JpaRepository<Restaurante, UUID> {

}
