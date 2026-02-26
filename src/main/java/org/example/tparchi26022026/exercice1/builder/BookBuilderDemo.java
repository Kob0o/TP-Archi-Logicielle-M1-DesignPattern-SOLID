package org.example.tparchi26022026.exercice1.builder;

import java.util.Arrays;
import java.util.List;


public class BookBuilderDemo {
    public static void main(String[] args) {
        System.out.println("=== Démonstration du Builder Pattern ===\n");

        Book book1 = new Book.BookBuilder("Le Seigneur des Anneaux", "J.R.R. Tolkien")
                .build();
        System.out.println("Book 1 (minimal): " + book1);
        System.out.println();

        Book book2 = new Book.BookBuilder("1984", "George Orwell")
                .publisher("Gallimard")
                .publicationYear(1949)
                .pageCount(328)
                .language("Français")
                .build();
        System.out.println("Book 2 (quelques attributs): " + book2);
        System.out.println();

        List<String> tags = Arrays.asList("Science-Fiction", "Dystopie", "Classique");
        Book book3 = new Book.BookBuilder("Fondation", "Isaac Asimov")
                .publisher("Denoël")
                .isbn("978-2-207-30000-1")
                .tags(tags)
                .publicationYear(1951)
                .pageCount(256)
                .language("Français")
                .description("Premier tome de la série Fondation")
                .build();
        System.out.println("Book 3 (complet): " + book3);
        System.out.println();

        Book book4 = new Book.BookBuilder("Clean Code", "Robert C. Martin")
                .isbn("978-0-13-235088-4")
                .tags(Arrays.asList("Programmation", "Best Practices"))
                .pageCount(464)
                .build();
        System.out.println("Book 4 (attributs spécifiques): " + book4);
    }
}
