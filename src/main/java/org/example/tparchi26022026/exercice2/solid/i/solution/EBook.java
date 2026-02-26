package org.example.tparchi26022026.exercice2.solid.i.solution;

public class EBook implements BookInfo, EReadable, Loanable {
    private final String title;
    private final String author;

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
    public void registerLoan() {
        System.out.println("Registering eBook loan...");
    }

    @Override
    public void calculateFine() {
        System.out.println("Calculating fine for eBook...");
    }
}
