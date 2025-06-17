package com.example.ch2labs.labs07.dto;

import lombok.Getter;

@Getter
public class TodoResponse
{
    private String id;
    private String title;
    private String completed;

    public TodoResponse(Todo todo)
    {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.completed = todo.getCompl();

    }
}
