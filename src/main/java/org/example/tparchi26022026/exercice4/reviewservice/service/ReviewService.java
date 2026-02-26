package org.example.tparchi26022026.exercice4.reviewservice.service;

import org.example.tparchi26022026.exercice4.reviewservice.dto.ReviewDTO;

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
