package org.example.tparchi26022026.exercice2.solid.i.problem;

public class EBook implements Book {
    private String title;
    private String author;

    public EBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void downloadPDF() {
        System.out.println("Downloading PDF...");
    }

    @Override
    public void openEReader() {
        System.out.println("Opening e-reader...");
    }

    @Override
    public void printBook() {
        throw new UnsupportedOperationException("Cannot print eBook!");
    }

    @Override
    public void bindBook() {
        throw new UnsupportedOperationException("Cannot bind eBook!");
    }

    @Override
    public void registerLoan() {
        System.out.println("Registering eBook loan...");
    }

    @Override
    public void calculateFine() {
        System.out.println("Calculating fine for eBook...");
    }
}
