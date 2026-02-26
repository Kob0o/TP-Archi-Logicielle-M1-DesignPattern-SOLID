package org.example.tparchi26022026.exercice3.util;

import org.example.tparchi26022026.exercice3.dto.BookDTO;
import org.example.tparchi26022026.exercice3.dto.LoanDTO;
import org.example.tparchi26022026.exercice3.dto.ReviewDTO;
import org.example.tparchi26022026.exercice3.dto.UserDTO;
import org.example.tparchi26022026.exercice3.model.Book;
import org.example.tparchi26022026.exercice3.model.Loan;
import org.example.tparchi26022026.exercice3.model.Review;
import org.example.tparchi26022026.exercice3.model.User;

public class DTOMapper {
    public static BookDTO toBookDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        dto.setPublisher(book.getPublisher());
        dto.setPublicationYear(book.getPublicationYear());
        dto.setPageCount(book.getPageCount());
        dto.setGenre(book.getGenre());
        return dto;
    }

    public static Book toBook(BookDTO dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        book.setPublisher(dto.getPublisher());
        book.setPublicationYear(dto.getPublicationYear());
        book.setPageCount(dto.getPageCount());
        book.setGenre(dto.getGenre());
        return book;
    }

    public static UserDTO toUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPhoneNumber(user.getPhoneNumber());
        return dto;
    }

    public static User toUser(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }

    public static LoanDTO toLoanDTO(Loan loan) {
        LoanDTO dto = new LoanDTO();
        dto.setId(loan.getId());
        dto.setUserId(loan.getUser().getId());
        dto.setBookId(loan.getBook().getId());
        dto.setLoanDate(loan.getLoanDate());
        dto.setReturnDate(loan.getReturnDate());
        dto.setDueDate(loan.getDueDate());
        dto.setFine(loan.getFine());
        dto.setIsReturned(loan.getIsReturned());
        return dto;
    }

    public static ReviewDTO toReviewDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setUserId(review.getUser().getId());
        dto.setBookId(review.getBook().getId());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setReviewDate(review.getReviewDate());
        return dto;
    }
}
