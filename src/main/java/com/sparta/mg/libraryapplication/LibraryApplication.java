package com.sparta.mg.libraryapplication;

import com.sparta.mg.libraryapplication.model.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


@SpringBootApplication
public class LibraryApplication {

    Logger logger = Logger.getLogger("AHHHH");

    final
    AuthorRepository repository;

    public LibraryApplication(AuthorRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(AuthorRepository repository) {
        return args -> logger.log(Level.SEVERE, repository.findAll().toString());
    }
}
