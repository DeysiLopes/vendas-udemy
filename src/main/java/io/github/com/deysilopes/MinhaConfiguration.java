package io.github.com.deysilopes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinhaConfiguration {

    @Bean(name = "appName")
    public String appName() {
        return "Sistema de vendas";
    }
}
