package com.example.ch4labs.dto;

import com.example.ch4labs.domain.Book;

public record BookResponse(
        Long id,
        String title,
        String author,
        String isbn,
        String publisher,
        String publishedDate
) {
    public static BookResponse from(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublisher(),
                book.getPublishedDate()
        );
    }
}
