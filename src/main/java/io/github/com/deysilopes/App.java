package io.github.com.deysilopes;

import io.github.com.deysilopes.domain.entity.Cliente;
import io.github.com.deysilopes.domain.repositories.Clientes;
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
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            System.out.println("Salvando clientes");
            clientes.salvarClientes(new Cliente("Deysi"));
            clientes.salvarClientes(new Cliente("Rafa"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando clientes");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado");
                clientes.atualizar(c);
            });

            todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando clientes");
            clientes.buscarPorNome("Raf").forEach(System.out::println);

//            System.out.println("Deletando clientes");
//            clientes.obterTodos().forEach(c -> {
//                clientes.deletar(c.getId());
//            });

            todosClientes = clientes.obterTodos();
            if (todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado");
            }else {
                todosClientes.forEach(System.out::println);
            }
        };

    }

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
