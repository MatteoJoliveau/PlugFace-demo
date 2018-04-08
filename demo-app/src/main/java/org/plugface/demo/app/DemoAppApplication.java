package org.plugface.demo.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoAppApplication {

    @Bean
    public CommandLineRunner test(DemoRunner runner) {
        return (args) -> {
            runner.run();
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoAppApplication.class, args);
    }
}
