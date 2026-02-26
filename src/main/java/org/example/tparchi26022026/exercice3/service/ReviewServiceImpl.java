package org.example.tparchi26022026.exercice3.service;

import org.example.tparchi26022026.exercice3.dto.ReviewDTO;
import org.example.tparchi26022026.exercice3.exception.ResourceNotFoundException;
import org.example.tparchi26022026.exercice3.model.Book;
import org.example.tparchi26022026.exercice3.model.Review;
import org.example.tparchi26022026.exercice3.model.User;
import org.example.tparchi26022026.exercice3.repository.BookRepository;
import org.example.tparchi26022026.exercice3.repository.ReviewRepository;
import org.example.tparchi26022026.exercice3.repository.UserRepository;
import org.example.tparchi26022026.exercice3.util.DTOMapper;
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
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(DTOMapper::toReviewDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDTO getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));
        return DTOMapper.toReviewDTO(review);
    }

    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        if (reviewDTO.getRating() < 1 || reviewDTO.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        User user = userRepository.findById(reviewDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + reviewDTO.getUserId()));
        
        Book book = bookRepository.findById(reviewDTO.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + reviewDTO.getBookId()));

        Review review = new Review();
        review.setUser(user);
        review.setBook(book);
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());
        review.setReviewDate(LocalDateTime.now());

        Review savedReview = reviewRepository.save(review);
        return DTOMapper.toReviewDTO(savedReview);
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
        return DTOMapper.toReviewDTO(updatedReview);
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
                .map(DTOMapper::toReviewDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId).stream()
                .map(DTOMapper::toReviewDTO)
                .collect(Collectors.toList());
    }
}
