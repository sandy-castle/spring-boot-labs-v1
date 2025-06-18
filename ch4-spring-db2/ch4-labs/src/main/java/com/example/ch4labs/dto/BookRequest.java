package com.example.ch4labs.dto;

public record BookRequest(
        String title,
        String author,
        String isbn,
        String publisher,
        String publishedDate
) {}
