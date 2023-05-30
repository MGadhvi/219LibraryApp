package com.sparta.mg.libraryapplication.controller;

import com.sparta.mg.libraryapplication.model.dtos.AuthorDTO;
import com.sparta.mg.libraryapplication.model.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping("/author")
    public AuthorDTO addAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorRepository.save(authorDTO);
    }
}
