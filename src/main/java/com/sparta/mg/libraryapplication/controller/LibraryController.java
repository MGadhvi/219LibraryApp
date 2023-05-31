package com.sparta.mg.libraryapplication.controller;

import com.sparta.mg.libraryapplication.model.dtos.AuthorDTO;
import com.sparta.mg.libraryapplication.model.dtos.BookDTO;
import com.sparta.mg.libraryapplication.model.repositories.AuthorRepository;
import com.sparta.mg.libraryapplication.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class LibraryController {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public LibraryController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/author/{id}")
    public HttpEntity<AuthorDTO> getAuthorById(@PathVariable Integer id) {
        AuthorDTO authorDTO = authorRepository.findById(id).get();
        authorDTO.add(linkTo(methodOn(LibraryController.class).getAuthorById(id)).withSelfRel());
        return new ResponseEntity<>(authorDTO, HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public HttpEntity<BookDTO> getBookById(@PathVariable Integer id) {
        BookDTO bookDTO = bookRepository.findById(id).get();
        bookDTO.add(linkTo(methodOn(LibraryController.class).getAuthorById(id)).withSelfRel());
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @GetMapping("/author/{id}/books")
    public CollectionModel<BookDTO> getAllBooksByAuthorId(@PathVariable Integer id) {
        List<BookDTO> books = authorRepository.findById(id).get().getBooks();
        for (BookDTO bookDTO: books) {
            Link link = linkTo(methodOn(LibraryController.class).getBookById(bookDTO.getId())).withSelfRel();
            bookDTO.add(link);
        }
        Link link = linkTo(methodOn(LibraryController.class).getAllBooksByAuthorId(id)).withSelfRel();
        return CollectionModel.of(books, link);
    }

    @GetMapping("/authors")
    public CollectionModel<AuthorDTO> getAllAuthors() {
        List<AuthorDTO> authors = authorRepository.findAll();
        for (AuthorDTO authorDTO: authors) {
            authorDTO.add(linkTo(methodOn(LibraryController.class).getAuthorById(authorDTO.getId())).withSelfRel());
            authorDTO.add(linkTo(methodOn(LibraryController.class).getAllBooksByAuthorId(authorDTO.getId())).withRel("books"));
        }
        return CollectionModel.of(authors, linkTo(LibraryController.class).withSelfRel());
    }
}
