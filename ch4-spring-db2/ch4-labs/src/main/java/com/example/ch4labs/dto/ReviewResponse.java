package com.example.ch4labs.dto;

import com.example.ch4labs.domain.Review;

public class ReviewResponse {

    public ReviewResponse(Review review)
    {
        this.id = review.getId();
        this.title = review.getTitle();
        this.content = review.getContent();
        this.author = review.getAuthor();
        this.bookTitle = review.getBookTitle();
        this.bookAuthor = review.getBookAuthor();
    }
    private Long id;
    private String title;
    private String content;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private int rating;
}
