package com._04_3tiers_crud.service;

import com._04_3tiers_crud.domain.Post;
import com._04_3tiers_crud.dto.PostResponse;
import com._04_3tiers_crud.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 게시글 저장
    public PostResponse save(Post post) {
        Post saved = postRepository.save(post);
        return PostResponse.from(saved);
    }

    // 단일 게시글 조회
    public PostResponse findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 게시글이 없습니다"));
        return PostResponse.from(post);
    }

    // 전체 게시글 목록 조회
    public List<PostResponse> findAll() {
        return postRepository.findAll()
                .stream()
                .map(PostResponse::from)
                .collect(Collectors.toList());
    }
}
