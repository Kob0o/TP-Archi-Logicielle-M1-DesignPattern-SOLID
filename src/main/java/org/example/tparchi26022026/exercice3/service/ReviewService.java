package org.example.tparchi26022026.exercice3.service;

import org.example.tparchi26022026.exercice3.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> getAllReviews();
    ReviewDTO getReviewById(Long id);
    ReviewDTO createReview(ReviewDTO reviewDTO);
    ReviewDTO updateReview(Long id, ReviewDTO reviewDTO);
    void deleteReview(Long id);
    List<ReviewDTO> getReviewsByBookId(Long bookId);
    List<ReviewDTO> getReviewsByUserId(Long userId);
}
