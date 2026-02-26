package org.example.tparchi26022026.exercice2.solid.i.problem;

public interface Book {
    String getTitle();
    String getAuthor();

    void downloadPDF();
    void openEReader();

    void printBook();
    void bindBook();

    void registerLoan();
    void calculateFine();
}
