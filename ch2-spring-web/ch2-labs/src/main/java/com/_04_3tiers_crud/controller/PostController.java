package com._04_3tiers_crud.controller;

import com._04_3tiers_crud.domain.Post;
import com._04_3tiers_crud.dto.PostResponse;
import com._04_3tiers_crud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        return ResponseEntity.ok(postService.findAll());
    }

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody Post post) {
        PostResponse saved = postService.save(post);
        return ResponseEntity.ok(saved);
    }
}
