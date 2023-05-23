package com.sparta.mg.libraryapplication;

import com.sparta.mg.libraryapplication.model.AuthorRepository;
import com.sparta.mg.libraryapplication.service.AuthorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class LibraryApplicationTests {

    @Autowired
    AuthorRepository repository;

    @Autowired
    AuthorService service;

    @Test
    @DisplayName("Check for all author")
    void checkForAllAuthor() {
        assertEquals("Manish", repository.findById(1).get().getFullName());
    }

    @Test
    @DisplayName("Check for author by name")
    void checkForAuthorByName() {
        assertEquals("Manish",repository.findByNameSQL("Manish").get().getFullName());
    }

    @Test
    @DisplayName("Check For Author Name Length")
    void checkForAuthorNameLength() {
        assertEquals(6,service.getLengthOfAuthorName(1));
    }
}
