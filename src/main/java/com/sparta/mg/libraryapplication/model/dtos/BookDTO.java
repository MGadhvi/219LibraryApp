package com.sparta.mg.libraryapplication.model.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sparta.mg.libraryapplication.model.dtos.AuthorDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "books")
public class BookDTO extends RepresentationModel<BookDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "title", length = 100)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "author_id")
    private AuthorDTO author;

    public BookDTO(Integer id, String title, AuthorDTO author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public BookDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}