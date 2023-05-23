package com.sparta.mg.libraryapplication.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorDTO, Integer> {
}