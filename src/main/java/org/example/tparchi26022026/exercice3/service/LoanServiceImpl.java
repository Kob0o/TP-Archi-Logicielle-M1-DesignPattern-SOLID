package org.example.tparchi26022026.exercice3.service;

import org.example.tparchi26022026.exercice3.dto.LoanDTO;
import org.example.tparchi26022026.exercice3.exception.ResourceNotFoundException;
import org.example.tparchi26022026.exercice3.model.Book;
import org.example.tparchi26022026.exercice3.model.Loan;
import org.example.tparchi26022026.exercice3.model.User;
import org.example.tparchi26022026.exercice3.repository.BookRepository;
import org.example.tparchi26022026.exercice3.repository.LoanRepository;
import org.example.tparchi26022026.exercice3.repository.UserRepository;
import org.example.tparchi26022026.exercice3.util.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<LoanDTO> getAllLoans() {
        return loanRepository.findAll().stream()
                .map(DTOMapper::toLoanDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LoanDTO getLoanById(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + id));
        return DTOMapper.toLoanDTO(loan);
    }

    @Override
    public LoanDTO createLoan(LoanDTO loanDTO) {
        User user = userRepository.findById(loanDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + loanDTO.getUserId()));
        
        Book book = bookRepository.findById(loanDTO.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + loanDTO.getBookId()));

        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setLoanDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusDays(14));
        loan.setIsReturned(false);
        loan.setFine(0.0);

        Loan savedLoan = loanRepository.save(loan);
        return DTOMapper.toLoanDTO(savedLoan);
    }

    @Override
    public LoanDTO returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + loanId));
        
        if (loan.getIsReturned()) {
            throw new IllegalArgumentException("Book already returned");
        }

        loan.setReturnDate(LocalDate.now());
        loan.setIsReturned(true);

        if (loan.getReturnDate().isAfter(loan.getDueDate())) {
            long daysLate = loan.getReturnDate().toEpochDay() - loan.getDueDate().toEpochDay();
            loan.setFine(daysLate * 0.5);
        }

        Loan updatedLoan = loanRepository.save(loan);
        return DTOMapper.toLoanDTO(updatedLoan);
    }

    @Override
    public List<LoanDTO> getLoansByUserId(Long userId) {
        return loanRepository.findByUserId(userId).stream()
                .map(DTOMapper::toLoanDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LoanDTO> getLoansByBookId(Long bookId) {
        return loanRepository.findByBookId(bookId).stream()
                .map(DTOMapper::toLoanDTO)
                .collect(Collectors.toList());
    }
}
