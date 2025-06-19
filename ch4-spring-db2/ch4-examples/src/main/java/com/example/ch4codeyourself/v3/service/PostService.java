package com.example.ch4codeyourself.v3.service;

import com.example.ch4codeyourself.v3.domain.Post;
import com.example.ch4codeyourself.v3.dto.*;
import com.example.ch4codeyourself.v3.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    // mapper -> JPA repository
    private final PostRepository postRepository;

    public PostResponse createPost(PostCreateRequest request) {
        Post post = request.toDomain();
        Post saved = postRepository.save(post); // ???
        return PostResponse.from(saved);
    }

//    @Transactional(readOnly = true)
//    public PostPageResponse getAllPosts(PostSearchRequest search) {
//
//        // author 가 포함되어 있으면 -> findByAuthor
//        // keyword 가 포함되어 있으면 -> findByTitleContaining
//
//        Pageable pageable = PageRequest.of(search.getPage(), search.getSize());
//
//        // /posts?keyword=스프링&author=윤지수
//
//        Page<Post> posts = null;
//        if (search.getKeyword() != null && search.getAuthor() != null){
//            // posts = postRepository.findByTitleContainingAndAuthor(search.getKeyword(), search.getAuthor(), pageable);
//            posts = postRepository.searchByTitleContainingAndAuthor(search.getKeyword(), search.getAuthor(), pageable);
//        } else if (search.getKeyword() != null) {
//            posts = postRepository.findByTitleContaining(search.getKeyword(), pageable);
//        } else if (search.getAuthor() != null) {
//            posts = postRepository.findByAuthor(search.getAuthor(), pageable);
//        } else if (search.getCreatedAt() != null) {
//            // posts = postRepository.findByCreatedAtAfter(search.getCreatedAt(), pageable);
//            // posts = postRepository.searchByAuthorAndTitle(search.getCreatedAt(), pageable);
//            posts = postRepository.searchByCreatedAtWithQueryDSL(search.getCreatedAt(), pageable);
//        } else {
//            posts = postRepository.findAll(pageable);
//        }
//
//        Page<PostResponse> page = posts.map(post -> PostResponse.from(post));
//
//        return PostPageResponse.from(page.getContent(), search, page.getTotalElements());
//    }

    @Transactional(readOnly = true)
    public PostPageResponse getAllPosts(PostSearchRequest request) {
        Page<PostResponse> page = postRepository.search(request);
        return PostPageResponse.from(page.getContent(), request, page.getTotalElements());
    }

    @Transactional(readOnly = true)
    public PostResponse getPostById(Long id) {
        return postRepository.findById(id)
                .map(PostResponse::from)
                .orElseThrow(() -> new NoSuchElementException("게시글이 존재하지 않습니다."));
    }

    public PostResponse updatePost(Long id, PostUpdateRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("게시글이 존재하지 않습니다."));

        // 트랜잭션이 끝날 때.
        // 변경이 일어나면 dirty checking -> SQL.

        post.setTitle(request.getTitle());
        post.setBody(request.getBody());

        return PostResponse.from(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}