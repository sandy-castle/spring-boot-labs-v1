package com.example.ch4labs.service;

import com.example.ch4labs.domain.Book;
import com.example.ch4labs.dto.BookRequest;
import com.example.ch4labs.dto.BookResponse;
import com.example.ch4labs.exception.NotFoundException;
import com.example.ch4labs.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse save(BookRequest req) {
        Book book = new Book(null,
                req.title(),
                req.author(),
                req.isbn(),
                req.publisher(),
                req.publishedDate());
        return BookResponse.from(bookRepository.save(book));
    }

    public List<BookResponse> findAll() {
        return bookRepository.findAll().stream()
                .map(BookResponse::from)
                .toList();
    }

    public BookResponse update(Long id, BookRequest req) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("책을 찾을 수 없습니다: " + id));

        book.setTitle(req.title());
        book.setAuthor(req.author());
        book.setIsbn(req.isbn());
        book.setPublisher(req.publisher());
        book.setPublishedDate(req.publishedDate());

        return BookResponse.from(bookRepository.save(book));
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
