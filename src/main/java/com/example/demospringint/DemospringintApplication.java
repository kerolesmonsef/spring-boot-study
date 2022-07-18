package com.example.demospringint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class DemospringintApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(DemospringintApplication.class, args);
    }

}
