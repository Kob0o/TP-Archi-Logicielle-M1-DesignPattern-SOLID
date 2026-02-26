package org.example.tparchi26022026.exercice1.singleton;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Démonstration du Singleton Pattern ===\n");

        // ===== APPROCHE 1 : Lazy Initialization =====
        System.out.println("--- Approche 1 : Lazy Initialization ---");
        
        DatabaseConfig config1 = DatabaseConfig.getInstance();
        config1.displayConfig();
        System.out.println();

        DatabaseConfig config2 = DatabaseConfig.getInstance();
        config2.setDatabaseUrl("jdbc:h2:mem:testdb");
        
        System.out.println("Vérification que config1 et config2 sont la même instance:");
        System.out.println("config1 == config2 : " + (config1 == config2));
        System.out.println("config1.getDatabaseUrl() : " + config1.getDatabaseUrl());
        System.out.println("config2.getDatabaseUrl() : " + config2.getDatabaseUrl());
        System.out.println();

        // ===== APPROCHE 2 : Enum Singleton =====
        System.out.println("--- Approche 2 : Enum Singleton ---");
        
        LibraryConfig library1 = LibraryConfig.INSTANCE;
        library1.displayConfig();
        System.out.println();

        LibraryConfig library2 = LibraryConfig.INSTANCE;
        library2.setLibraryName("Bibliothèque Nationale");
        
        System.out.println("Vérification que library1 et library2 sont la même instance:");
        System.out.println("library1 == library2 : " + (library1 == library2));
        System.out.println("library1.getLibraryName() : " + library1.getLibraryName());
        System.out.println("library2.getLibraryName() : " + library2.getLibraryName());
        System.out.println();

        // ===== COMPARAISON =====
        System.out.println("=== Comparaison des approches ===");
        System.out.println("Lazy Initialization :");
        System.out.println("  + Instance créée uniquement si nécessaire");
        System.out.println("  + Peut être étendue (héritage possible)");
        System.out.println("  - Nécessite du code supplémentaire pour thread-safety");
        System.out.println("  - Peut être contournée par réflexion");
        System.out.println();
        System.out.println("Enum Singleton :");
        System.out.println("  + Thread-safe par défaut");
        System.out.println("  + Sérialisation automatique");
        System.out.println("  + Protection contre la réflexion");
        System.out.println("  + Code plus simple et concis");
        System.out.println("  - Ne peut pas être étendue (pas d'héritage)");
        System.out.println();
        System.out.println("Question : Pourquoi l'Enum Singleton est-il supérieur au Singleton classique ?");
        System.out.println("Réponse : L'Enum Singleton est supérieur car il garantit automatiquement");
        System.out.println("         l'unicité de l'instance, la thread-safety, et la protection");
        System.out.println("         contre la sérialisation et la réflexion, sans code supplémentaire.");
    }
}
