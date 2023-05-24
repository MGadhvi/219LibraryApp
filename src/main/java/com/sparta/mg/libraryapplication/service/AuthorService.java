package com.sparta.mg.libraryapplication.service;

import com.sparta.mg.libraryapplication.model.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public int getLengthOfAuthorName(Integer id) {
        return repository.findById(id).get().getFullName().length();
    }
}
