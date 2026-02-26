package org.example.tparchi26022026.exercice4.loanservice.service;

import org.example.tparchi26022026.exercice4.loanservice.client.BookServiceClient;
import org.example.tparchi26022026.exercice4.loanservice.client.UserServiceClient;
import org.example.tparchi26022026.exercice4.loanservice.dto.LoanDTO;
import org.example.tparchi26022026.exercice4.loanservice.exception.ResourceNotFoundException;
import org.example.tparchi26022026.exercice4.loanservice.model.Loan;
import org.example.tparchi26022026.exercice4.loanservice.repository.LoanRepository;
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
    private BookServiceClient bookServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;

    @Override
    public List<LoanDTO> getAllLoans() {
        return loanRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LoanDTO getLoanById(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + id));
        return toDTO(loan);
    }

    @Override
    public LoanDTO createLoan(LoanDTO loanDTO) {
        if (!userServiceClient.userExists(loanDTO.getUserId())) {
            throw new ResourceNotFoundException("User not found with id: " + loanDTO.getUserId());
        }
        
        if (!bookServiceClient.bookExists(loanDTO.getBookId())) {
            throw new ResourceNotFoundException("Book not found with id: " + loanDTO.getBookId());
        }

        Loan loan = new Loan();
        loan.setUserId(loanDTO.getUserId());
        loan.setBookId(loanDTO.getBookId());
        loan.setLoanDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusDays(14));
        loan.setIsReturned(false);
        loan.setFine(0.0);

        Loan savedLoan = loanRepository.save(loan);
        return toDTO(savedLoan);
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
        return toDTO(updatedLoan);
    }

    @Override
    public List<LoanDTO> getLoansByUserId(Long userId) {
        return loanRepository.findByUserId(userId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LoanDTO> getLoansByBookId(Long bookId) {
        return loanRepository.findByBookId(bookId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private LoanDTO toDTO(Loan loan) {
        LoanDTO dto = new LoanDTO();
        dto.setId(loan.getId());
        dto.setUserId(loan.getUserId());
        dto.setBookId(loan.getBookId());
        dto.setLoanDate(loan.getLoanDate());
        dto.setReturnDate(loan.getReturnDate());
        dto.setDueDate(loan.getDueDate());
        dto.setFine(loan.getFine());
        dto.setIsReturned(loan.getIsReturned());
        return dto;
    }
}
