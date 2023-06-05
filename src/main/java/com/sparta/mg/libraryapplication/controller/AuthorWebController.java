package com.sparta.mg.libraryapplication.controller;

import com.sparta.mg.libraryapplication.model.dtos.AuthorDTO;
import com.sparta.mg.libraryapplication.model.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorWebController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorWebController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }

    @GetMapping("/author/{id}")
    public String getAuthor(Model model, @PathVariable Integer id) {
        model.addAttribute("author",
                authorRepository.findById(id).orElse(null));
        return "author";
    }

    @GetMapping("/author/edit/{id}")
    public String getAuthorToEdit(@PathVariable Integer id, Model model) {
        AuthorDTO author = authorRepository.findById(id).orElse(null);
        model.addAttribute("authorToEdit", author);
        return "author-edit-form";
    }

    @PostMapping("/updateAuthor")
    public String updateAuthor(@ModelAttribute("authorToEdit")AuthorDTO editedAuthor) {
        authorRepository.saveAndFlush(editedAuthor);
        return "edit-success";
    }
}
