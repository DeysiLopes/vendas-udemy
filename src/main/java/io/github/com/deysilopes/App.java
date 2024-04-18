package io.github.com.deysilopes;

import io.github.com.deysilopes.domain.entity.Cliente;
import io.github.com.deysilopes.domain.entity.Pedido;
import io.github.com.deysilopes.domain.repositories.ClienteRepository;
import io.github.com.deysilopes.domain.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class App {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository clienteRepository, @Autowired PedidoRepository pedidoRepository) {
        return args -> {
            System.out.println("Salvando clientes");
            Cliente deysi = clienteRepository.save(new Cliente("Deysi"));
            clienteRepository.save(new Cliente("Rafa"));

            Pedido pedido = new Pedido();
            pedido.setCliente(deysi);
            pedido.setDataPedido(LocalDate.now());
            pedido.setTotal(BigDecimal.valueOf(800.5));

            pedidoRepository.save(pedido);

            Cliente clienteFetchPedidos = clienteRepository.findClienteFetchPedidos(deysi.getId());
            System.out.println(clienteFetchPedidos);
            System.out.println(clienteFetchPedidos.getPedidos()); 

//            pedidoRepository.findByCliente(deysi).forEach(System.out::println);
        };

    }

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
