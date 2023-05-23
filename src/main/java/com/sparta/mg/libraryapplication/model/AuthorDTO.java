package com.sparta.mg.libraryapplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "authors")
public class AuthorDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", nullable = false)
    private Integer id;

    @Size(max = 40)
    @Column(name = "full_name", length = 40)
    private String fullName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}