package org.example.tparchi26022026.exercice2.solid.i.solution;

public class PrintedBook implements BookInfo, Printable, Loanable {
    private String title;
    private String author;

    public PrintedBook(String title, String author) {
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
    public void printBook() {
        System.out.println("Printing book...");
    }

    @Override
    public void bindBook() {
        System.out.println("Binding book...");
    }

    @Override
    public void registerLoan() {
        System.out.println("Registering printed book loan...");
    }

    @Override
    public void calculateFine() {
        System.out.println("Calculating fine for printed book...");
    }
}
