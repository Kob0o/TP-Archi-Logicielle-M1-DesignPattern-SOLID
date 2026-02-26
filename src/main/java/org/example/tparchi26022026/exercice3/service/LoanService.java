package org.example.tparchi26022026.exercice3.service;

import org.example.tparchi26022026.exercice3.dto.LoanDTO;

import java.util.List;

public interface LoanService {
    List<LoanDTO> getAllLoans();
    LoanDTO getLoanById(Long id);
    LoanDTO createLoan(LoanDTO loanDTO);
    LoanDTO returnBook(Long loanId);
    List<LoanDTO> getLoansByUserId(Long userId);
    List<LoanDTO> getLoansByBookId(Long bookId);
}
