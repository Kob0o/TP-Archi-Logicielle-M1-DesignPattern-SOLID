package org.example.tparchi26022026.exercice4.reviewservice.service;

import org.example.tparchi26022026.exercice4.reviewservice.client.BookServiceClient;
import org.example.tparchi26022026.exercice4.reviewservice.client.UserServiceClient;
import org.example.tparchi26022026.exercice4.reviewservice.dto.ReviewDTO;
import org.example.tparchi26022026.exercice4.reviewservice.exception.ResourceNotFoundException;
import org.example.tparchi26022026.exercice4.reviewservice.model.Review;
import org.example.tparchi26022026.exercice4.reviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookServiceClient bookServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;

    @Override
    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDTO getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));
        return toDTO(review);
    }

    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        if (reviewDTO.getRating() < 1 || reviewDTO.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        if (!userServiceClient.userExists(reviewDTO.getUserId())) {
            throw new ResourceNotFoundException("User not found with id: " + reviewDTO.getUserId());
        }
        
        if (!bookServiceClient.bookExists(reviewDTO.getBookId())) {
            throw new ResourceNotFoundException("Book not found with id: " + reviewDTO.getBookId());
        }

        Review review = new Review();
        review.setUserId(reviewDTO.getUserId());
        review.setBookId(reviewDTO.getBookId());
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());
        review.setReviewDate(LocalDateTime.now());

        Review savedReview = reviewRepository.save(review);
        return toDTO(savedReview);
    }

    @Override
    public ReviewDTO updateReview(Long id, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));

        if (reviewDTO.getRating() != null && (reviewDTO.getRating() < 1 || reviewDTO.getRating() > 5)) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());

        Review updatedReview = reviewRepository.save(review);
        return toDTO(updatedReview);
    }

    @Override
    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new ResourceNotFoundException("Review not found with id: " + id);
        }
        reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewDTO> getReviewsByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ReviewDTO toDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setUserId(review.getUserId());
        dto.setBookId(review.getBookId());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setReviewDate(review.getReviewDate());
        return dto;
    }
}
