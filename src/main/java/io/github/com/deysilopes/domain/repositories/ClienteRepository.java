package io.github.com.deysilopes.domain.repositories;

import io.github.com.deysilopes.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Object> findByNomeLike(String nome);

    //List<Object> findByOrId(String nome, Integer id);
    boolean existsByNome(String nome);
}
