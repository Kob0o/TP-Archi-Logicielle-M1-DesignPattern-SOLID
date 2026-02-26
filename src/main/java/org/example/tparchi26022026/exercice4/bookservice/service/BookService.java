package org.example.tparchi26022026.exercice4.bookservice.service;

import org.example.tparchi26022026.exercice4.bookservice.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
    BookDTO createBook(BookDTO bookDTO);
    BookDTO updateBook(Long id, BookDTO bookDTO);
    void deleteBook(Long id);
    boolean existsById(Long id);
}
