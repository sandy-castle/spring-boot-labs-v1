package com._04_3tiers_crud.config;

import com._04_3tiers_crud.domain.Post;
import com._04_3tiers_crud.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final PostRepository repository;

    @PostConstruct
    public void init() {
        repository.save(new Post(null, "첫번째 게시글", "첫번째 내용"));
        repository.save(new Post(null, "두번째 게시글", "두번째 내용"));
        repository.save(new Post(null, "세번째 게시글", "세번째 내용"));
    }
}
