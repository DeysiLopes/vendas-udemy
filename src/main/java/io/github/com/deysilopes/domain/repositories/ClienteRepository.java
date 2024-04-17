package io.github.com.deysilopes.domain.repositories;

import io.github.com.deysilopes.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Object> findByNomeLike(String nome);

    //List<Object> findByOrId(String nome, Integer id);
    boolean existsByNome(String nome);

//    @Query(value = "select c from Cliente  c where c.nome like :nome") jpql
    @Query(value = "select * from cliente  c where c.nome like '%:nome%'", nativeQuery = true)
    List<Cliente> encontrarPorNome(@Param("nome") String nome);


    @Query(value = "delete from Cliente c where c.nome = :nome")
    @Modifying
    void deletePorNome(String nome);
}
