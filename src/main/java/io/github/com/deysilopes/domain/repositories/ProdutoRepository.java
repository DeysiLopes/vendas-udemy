package io.github.com.deysilopes.domain.repositories;

import io.github.com.deysilopes.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
