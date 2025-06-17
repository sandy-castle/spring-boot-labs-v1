package com.example.ch2labs.labs07.service;

import com.example.ch2labs.labs07.domain.Todo;
import com.example.ch2labs.labs07.dto.TodoRequest;
import com.example.ch2labs.labs07.dto.TodoResponse;
import com.example.ch2labs.labs07.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public TodoResponse save(TodoRequest request) {
        if (request.getTitle() == null || request.getTitle().isBlank()) {
            throw new IllegalArgumentException("할 일 제목은 필수입니다");
        }

        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        todo.setCompleted(request.isCompleted());

        Todo saved = repository.save(todo);
        return new TodoResponse(saved);
    }
}
