package com.sparta.week02hw;

import com.sparta.week02hw.domain.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Week02HwApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week02HwApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository repository) {
        return (args) -> {

        };
    }
}
