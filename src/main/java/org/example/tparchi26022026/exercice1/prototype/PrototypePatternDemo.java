package org.example.tparchi26022026.exercice1.prototype;

public class PrototypePatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Démonstration du Prototype Pattern ===\n");

        // Création d'un profil utilisateur
        UserPreferences originalPreferences = new UserPreferences();
        originalPreferences.setPreferredLanguage("Français");
        originalPreferences.setTheme("Dark");
        originalPreferences.addFavoriteGenre("Science-Fiction");
        originalPreferences.addFavoriteGenre("Fantasy");
        originalPreferences.addFavoriteAuthor("Isaac Asimov");
        originalPreferences.addFavoriteAuthor("J.R.R. Tolkien");
        originalPreferences.setMaxResultsPerPage(20);
        originalPreferences.setEmailNotifications(true);
        originalPreferences.setSmsNotifications(false);

        System.out.println("=== Préférences Originales ===");
        System.out.println(originalPreferences);
        System.out.println();

        // Clonage pour créer un nouveau profil utilisateur
        UserPreferences clonedPreferences = originalPreferences.clone();
        
        System.out.println("=== Préférences Clonées (avant modification) ===");
        System.out.println(clonedPreferences);
        System.out.println();

        // Modification du clone
        clonedPreferences.setPreferredLanguage("English");
        clonedPreferences.setTheme("Light");
        clonedPreferences.addFavoriteGenre("Mystery");
        clonedPreferences.addFavoriteAuthor("Agatha Christie");
        clonedPreferences.setMaxResultsPerPage(50);

        System.out.println("=== Préférences Clonées (après modification) ===");
        System.out.println(clonedPreferences);
        System.out.println();

        // Vérification que l'original n'a pas été affecté
        System.out.println("=== Vérification : Préférences Originales (non modifiées) ===");
        System.out.println(originalPreferences);
        System.out.println();

        // Test de deep copy : vérification que les listes sont indépendantes
        System.out.println("=== Test de Deep Copy ===");
        System.out.println("Original favoriteGenres: " + originalPreferences.getFavoriteGenres());
        System.out.println("Cloned favoriteGenres: " + clonedPreferences.getFavoriteGenres());
        System.out.println("Les listes sont-elles la même référence ? " + 
                (originalPreferences.getFavoriteGenres() == clonedPreferences.getFavoriteGenres()));
        System.out.println();

        // Ajout d'un genre au clone
        clonedPreferences.addFavoriteGenre("Thriller");
        System.out.println("Après ajout de 'Thriller' au clone:");
        System.out.println("Original favoriteGenres: " + originalPreferences.getFavoriteGenres());
        System.out.println("Cloned favoriteGenres: " + clonedPreferences.getFavoriteGenres());
        System.out.println();

        System.out.println("=== Pourquoi une Deep Copy est importante ? ===");
        System.out.println("Une deep copy est essentielle car :");
        System.out.println("1. Elle crée des copies indépendantes des objets complexes (listes, etc.)");
        System.out.println("2. Les modifications sur le clone n'affectent pas l'original");
        System.out.println("3. Chaque utilisateur a ses propres préférences sans partage de références");
        System.out.println("4. Évite les effets de bord et les bugs difficiles à détecter");
    }
}
