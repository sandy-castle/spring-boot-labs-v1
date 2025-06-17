package com.example.ch2labs.labs07.repository;

import com.example.ch2labs.labs07.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
