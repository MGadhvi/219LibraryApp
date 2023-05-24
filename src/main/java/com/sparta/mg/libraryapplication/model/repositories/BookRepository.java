package com.sparta.mg.libraryapplication.model.repositories;

import com.sparta.mg.libraryapplication.model.dtos.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookDTO, Integer> {
}