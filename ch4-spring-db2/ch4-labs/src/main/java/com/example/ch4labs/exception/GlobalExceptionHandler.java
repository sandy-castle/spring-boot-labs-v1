package com.example.ch4labs.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handle(NotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
