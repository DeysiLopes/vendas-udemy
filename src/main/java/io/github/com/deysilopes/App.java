package io.github.com.deysilopes;

import io.github.com.deysilopes.domain.entity.Cliente;
import io.github.com.deysilopes.domain.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class App {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository clienteRepository) {
        return args -> {
            System.out.println("Salvando clientes");
            clienteRepository.save(new Cliente("Deysi"));
            clienteRepository.save(new Cliente("Rafa"));

            boolean existe = clienteRepository.existsByNome("Deysi");
            System.out.println("existe um cliente com o nome Deysi? " + existe);
        };

    }

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
