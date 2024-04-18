package io.github.com.deysilopes.domain.repositories;

import io.github.com.deysilopes.domain.entity.Cliente;
import io.github.com.deysilopes.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente);
}
