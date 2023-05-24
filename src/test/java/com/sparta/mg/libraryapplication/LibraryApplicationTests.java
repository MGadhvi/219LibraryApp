package com.sparta.mg.libraryapplication;

import com.sparta.mg.libraryapplication.model.repositories.AuthorRepository;
import com.sparta.mg.libraryapplication.model.repositories.BookRepository;
import com.sparta.mg.libraryapplication.service.AuthorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class LibraryApplicationTests {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService service;

    @Test
    @DisplayName("Check for all author")
    void checkForAllAuthor() {
        assertEquals("Manish", authorRepository.findById(1).get().getFullName());
    }

    @Test
    @DisplayName("Check for author by name")
    void checkForAuthorByName() {
        assertEquals("Manish", authorRepository.findByNameSQL("Manish").get().getFullName());
    }

    @Test
    @DisplayName("Check For Author Name Length")
    void checkForAuthorNameLength() {
        assertEquals(6,service.getLengthOfAuthorName(1));
    }

    @Test
    @DisplayName("Print Book")
    void printBook() {
        bookRepository.findById(2).ifPresent(System.out::println);
    }

    @Test
    @DisplayName("Print Author")
    void printAuthor() {
        authorRepository.findByNameSQL("Manish").ifPresent(authorDTO -> System.out.println(authorDTO.getBooks()));
    }
}
