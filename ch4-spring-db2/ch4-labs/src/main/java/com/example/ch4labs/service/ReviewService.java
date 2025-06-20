package com.example.ch4labs.service;

import com.example.ch4labs.controller.ReviewSearchRequest;
import com.example.ch4labs.domain.Review;
import com.example.ch4labs.dto.ReviewRequest;
import com.example.ch4labs.dto.ReviewResponse;
import com.example.ch4labs.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository repository;

    // 1. 리뷰 작성 (Create)
    public ReviewResponse create(ReviewRequest request) {
        Review review = new Review();

        review.setContent(request.getContent());
        review.setAuthor(request.getAuthor());
        review.setBookTitle(request.getBookTitle());
        review.setBookAuthor(request.getBookAuthor());
        review.setRating(request.getRating());

        Review saved = repository.save(review);
        return new ReviewResponse(saved);
    }

    // 2. 전체 리뷰 조회 (Read)
    public List<ReviewResponse> getAll() {
        return repository.findAll().stream()
                .map(ReviewResponse::new)
                .collect(Collectors.toList());
    }

    // 3. 리뷰 수정 (Update)
    public ReviewResponse update(Long id, ReviewRequest request) {
        Review review = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 리뷰가 없습니다: " + id));

        review.setTitle(request.getTitle());
        review.setContent(request.getContent());
        review.setAuthor(request.getAuthor());
        review.setBookTitle(request.getBookTitle());
        review.setBookAuthor(request.getBookAuthor());
        review.setRating(request.getRating());

        return new ReviewResponse(review); // 저장은 JPA가 자동 감지함
    }

    // 4. 리뷰 삭제 (Delete)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("삭제할 리뷰가 없습니다: " + id);
        }
        repository.deleteById(id);
    }

    public Page<ReviewResponse> search(ReviewSearchRequest request) {
        // 나중에 repository에서 조건별 검색해서 받아올 예정
        return null;
    }

}
