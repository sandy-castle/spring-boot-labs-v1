package com.example.ch2labs.labs07.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TodoRequest {
    private String title;
    private boolean completed;
}
