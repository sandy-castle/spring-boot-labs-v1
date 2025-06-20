package com.example.ch4codeyourself.v4.repository.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
<<<<<<< HEAD:ch4-spring-db2/ch4-examples/src/main/java/com/example/ch4codeyourself/v4/repository/post/PostRepository.java
public interface PostRepository extends JpaRepository<com.example.ch4codeyourself.v4.domain.Post, Long>, PostQueryRepository {
    // 제목에 검색어 포함
    Page<com.example.ch4codeyourself.v4.domain.Post> findByTitleContaining(String keyword, Pageable pageable);
    // 작성자와 검색어 일치
    Page<com.example.ch4codeyourself.v4.domain.Post> findByAuthor(String author, Pageable pageable);
    // 제목에 검색어 포함 + 작성자와 검색어 일치
    Page<com.example.ch4codeyourself.v4.domain.Post> findByAuthorAndTitleContaining(String author, String title, Pageable pageable);
    // 작성일자 이후
    Page<com.example.ch4codeyourself.v4.domain.Post> findByCreatedAtAfter(LocalDateTime createdAt, Pageable pageable);
=======
public interface PostRepository extends JpaRepository<Post, Long>, PostQueryRepository {
    // 제목에 검색어 포함
    Page<Post> findByTitleContaining(String keyword, Pageable pageable);
    // 작성자와 검색어 일치
    Page<Post> findByAuthor(String author, Pageable pageable);
    // 제목에 검색어 포함 + 작성자와 검색어 일치
    Page<Post> findByAuthorAndTitleContaining(String author, String title, Pageable pageable);
    // 작성일자 이후
    Page<Post> findByCreatedAtAfter(LocalDateTime createdAt, Pageable pageable);
>>>>>>> upstream/main:ch4-spring-db2/ch4-examples/src/main/java/com/captainyun7/ch4examples/v4/repository/post/PostRepository.java

    @Query("SELECT p FROM Post p WHERE p.author = :author AND p.title LIKE %:title%")
    Page<com.example.ch4codeyourself.v4.domain.Post> searchByAuthorAndTitle(@Param("author") String author, @Param("title") String title, Pageable pageable);

    @Query("SELECT p FROM Post p WHERE p.createdAt >= :createdAt")
<<<<<<< HEAD:ch4-spring-db2/ch4-examples/src/main/java/com/example/ch4codeyourself/v4/repository/post/PostRepository.java
    Page<com.example.ch4codeyourself.v4.domain.Post> searchByCreatedAfter(@Param("createdAt") LocalDateTime createdAt, Pageable pageable);
=======
    Page<com.captainyun7.ch4examples.v4.domain.Post> searchByCreatedAfter(@Param("createdAt") LocalDateTime createdAt, Pageable pageable);

    // fetch join
    @Query("""
    SELECT p FROM Post p
    LEFT JOIN FETCH p.comments
    WHERE p.id = :id
    """)
    Optional<Post> findByIdWithComments(@Param("id") Long id);

>>>>>>> upstream/main:ch4-spring-db2/ch4-examples/src/main/java/com/captainyun7/ch4examples/v4/repository/post/PostRepository.java
}
