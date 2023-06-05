package com.sparta.mg.libraryapplication;

import com.sparta.mg.libraryapplication.model.repositories.AuthorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LibraryApplication {

    AuthorRepository repository;

    public LibraryApplication(AuthorRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

}
