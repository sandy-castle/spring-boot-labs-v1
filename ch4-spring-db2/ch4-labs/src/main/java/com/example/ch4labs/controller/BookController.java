package com.example.ch4labs.controller;

import com.example.ch4labs.dto.BookRequest;
import com.example.ch4labs.dto.BookResponse;
import com.example.ch4labs.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse create(@RequestBody BookRequest request) {
        return bookService.save(request);
    }

    @GetMapping
    public List<BookResponse> getAll() {
        return bookService.findAll();
    }

    @PutMapping("/{id}")
    public BookResponse update(@PathVariable Long id, @RequestBody BookRequest request) {
        return bookService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}
