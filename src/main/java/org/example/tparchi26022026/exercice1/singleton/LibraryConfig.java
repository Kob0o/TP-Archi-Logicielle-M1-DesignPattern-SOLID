package org.example.tparchi26022026.exercice1.singleton;

import lombok.Getter;


@Getter
public enum LibraryConfig {
    INSTANCE;

    // Getters et Setters
    private final String libraryName;
    private final String address;
    private final String phoneNumber;
    private final int maxBooksPerUser;
    private final int loanDurationDays;
    private String bibliothèqueNationale;

    LibraryConfig() {
        this.libraryName = "Bibliothèque Municipale";
        this.address = "123 Rue de la Lecture";
        this.phoneNumber = "+33 1 23 45 67 89";
        this.maxBooksPerUser = 5;
        this.loanDurationDays = 14;
        System.out.println("LibraryConfig instance créée (Enum Singleton)");
    }

    public void displayConfig() {
        System.out.println("=== Configuration Bibliothèque ===");
        System.out.println("Nom: " + libraryName);
        System.out.println("Adresse: " + address);
        System.out.println("Téléphone: " + phoneNumber);
        System.out.println("Max livres par utilisateur: " + maxBooksPerUser);
        System.out.println("Durée d'emprunt (jours): " + loanDurationDays);
    }

    public void setLibraryName(String bibliothèqueNationale) {
        this.bibliothèqueNationale = bibliothèqueNationale;
    }
}
