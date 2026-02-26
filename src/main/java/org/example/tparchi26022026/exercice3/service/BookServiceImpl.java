package org.example.tparchi26022026.exercice3.service;

import org.example.tparchi26022026.exercice3.dto.BookDTO;
import org.example.tparchi26022026.exercice3.exception.ResourceNotFoundException;
import org.example.tparchi26022026.exercice3.model.Book;
import org.example.tparchi26022026.exercice3.repository.BookRepository;
import org.example.tparchi26022026.exercice3.util.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(DTOMapper::toBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        return DTOMapper.toBookDTO(book);
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = DTOMapper.toBook(bookDTO);
        Book savedBook = bookRepository.save(book);
        return DTOMapper.toBookDTO(savedBook);
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setPublisher(bookDTO.getPublisher());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setPageCount(bookDTO.getPageCount());
        book.setGenre(bookDTO.getGenre());
        
        Book updatedBook = bookRepository.save(book);
        return DTOMapper.toBookDTO(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDTO> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author).stream()
                .map(DTOMapper::toBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre).stream()
                .map(DTOMapper::toBookDTO)
                .collect(Collectors.toList());
    }
}
