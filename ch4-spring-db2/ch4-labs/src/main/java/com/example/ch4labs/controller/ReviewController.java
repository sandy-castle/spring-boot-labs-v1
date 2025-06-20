package com.example.ch4labs.controller;

import com.example.ch4labs.dto.ReviewRequest;
import com.example.ch4labs.dto.ReviewResponse;
import com.example.ch4labs.service.ReviewService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService service;

    @PostMapping
    public ResponseEntity<ReviewResponse> create(@RequestBody ReviewRequest request)
    {
        ReviewResponse response = service.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping

    public ResponseEntity<?> search(@ModelAttribute ReviewSearchRequest request) {
        return ResponseEntity.ok(service.search(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponse> update(@PathVariable Long id, @RequestBody ReviewRequest request) {
        ReviewResponse response = service.update(id, request);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
