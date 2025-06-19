package com.example.ch4codeyourself.v3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSearchRequest {
    private String keyword;
    private String author;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;
    private String sort;
    private int page = 1;
    private int size = 10;
}
