package io.github.com.deysilopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class App {

   @Value("${application.name}")
    private String appName;


    @GetMapping("/hello")
    public String hello(){
        return appName;
    }
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
