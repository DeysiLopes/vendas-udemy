package io.github.com.deysilopes.sevice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@Dev
public class MinhaConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("Rodando config de dev");
        };
    }
}
