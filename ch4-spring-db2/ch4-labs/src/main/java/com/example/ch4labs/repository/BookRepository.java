package com.example.ch4labs.repository;

import com.example.ch4labs.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}
