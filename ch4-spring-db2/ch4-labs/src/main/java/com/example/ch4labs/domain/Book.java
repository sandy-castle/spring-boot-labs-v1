package com.example.ch4labs.domain;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private String publishedDate;

    // 직접 만든 생성자
    public Book(Long id, String title, String author, String isbn, String publisher, String publishedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
    }

    // JPA용 기본 생성자
    public Book() {}

    // Getter, Setter
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public String getPublisher() { return publisher; }
    public String getPublishedDate() { return publishedDate; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setPublishedDate(String publishedDate) { this.publishedDate = publishedDate; }
}
