

package com.example.ch4labs.repository;

import org.springframework.data.jpa.repository.JpaRepository; // ✅ 이게 필요한 import 문
import com.example.ch4labs.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {}
