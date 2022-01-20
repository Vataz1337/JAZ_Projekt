package com.aplication.project.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository){
        return args -> {
            Client vataz = new Client(
                    1,
                    "Patryk",
                    "Sroka",
                    "patryksroka99@gmail.com",
                    "vataz",
                    "salto123"
            );
            Client pasiekacz = new Client(
                    2,
                    "Dawid",
                    "Pasieka",
                    "dawidpasieka@gmail.com",
                    "pasiekacz",
                    "fiza123"
            );

            repository.saveAll(
                    List.of(vataz, pasiekacz)
            );
        };
    }
}
