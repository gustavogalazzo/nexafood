package br.com.gustavo.nexafood.repository;

import br.com.gustavo.nexafood.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}