package com.sparta.mg.libraryapplication;

import com.sparta.mg.libraryapplication.model.dtos.AuthorDTO;
import com.sparta.mg.libraryapplication.model.repositories.AuthorRepository;
import com.sparta.mg.libraryapplication.model.repositories.BookRepository;
import com.sparta.mg.libraryapplication.service.AuthorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

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

    @Test
    @DisplayName("test author endpoint")
    void testAuthorEndpoint() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AuthorDTO> response = restTemplate.getForEntity("http://localhost:5000/author/1", AuthorDTO.class);
        assertEquals(HttpStatusCode.valueOf(200),response.getStatusCode());
    }

    @Test
    @DisplayName("Using Webclient")
    void usingWebclient() {
        String response = WebClient.create("http://localhost:5000/authors")
                .get()
                .retrieve()
                .toString();

        System.out.println(response);
    }
}
