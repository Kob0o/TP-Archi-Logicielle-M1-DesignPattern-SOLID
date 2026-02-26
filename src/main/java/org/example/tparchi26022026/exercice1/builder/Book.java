package org.example.tparchi26022026.exercice1.builder;

import lombok.Getter;

import java.util.List;

@Getter
public class Book {
    // Getters
    private final String title;
    private final String author;
    private final String publisher;
    private final String isbn;
    private final List<String> tags;
    private final Integer publicationYear;
    private final Integer pageCount;
    private final String language;
    private final String description;

    private Book(BookBuilder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.publisher = builder.publisher;
        this.isbn = builder.isbn;
        this.tags = builder.tags;
        this.publicationYear = builder.publicationYear;
        this.pageCount = builder.pageCount;
        this.language = builder.language;
        this.description = builder.description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", tags=" + tags +
                ", publicationYear=" + publicationYear +
                ", pageCount=" + pageCount +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class BookBuilder {
        private final String title;
        private final String author;
        private String publisher;
        private String isbn;
        private List<String> tags;
        private Integer publicationYear;
        private Integer pageCount;
        private String language;
        private String description;

        public BookBuilder(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public BookBuilder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public BookBuilder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookBuilder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public BookBuilder publicationYear(Integer publicationYear) {
            this.publicationYear = publicationYear;
            return this;
        }

        public BookBuilder pageCount(Integer pageCount) {
            this.pageCount = pageCount;
            return this;
        }

        public BookBuilder language(String language) {
            this.language = language;
            return this;
        }

        public BookBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
