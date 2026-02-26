package org.example.tparchi26022026.exercice3.service;

import org.example.tparchi26022026.exercice3.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
    BookDTO createBook(BookDTO bookDTO);
    BookDTO updateBook(Long id, BookDTO bookDTO);
    void deleteBook(Long id);
    List<BookDTO> getBooksByAuthor(String author);
    List<BookDTO> getBooksByGenre(String genre);
}
