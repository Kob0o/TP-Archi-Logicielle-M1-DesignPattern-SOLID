package org.example.tparchi26022026.exercice1.singleton;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class DatabaseConfig {
    private static volatile DatabaseConfig instance;

    // Getters et Setters
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;

    private DatabaseConfig() {
        this.databaseUrl = "jdbc:h2:mem:librarydb";
        this.username = "admin";
        this.password = "admin123";
        this.maxConnections = 10;
        System.out.println("DatabaseConfig instance créée (Lazy Initialization)");
    }

    public static DatabaseConfig getInstance() {
        if (instance == null) {
            synchronized (DatabaseConfig.class) {
                if (instance == null) {
                    instance = new DatabaseConfig();
                }
            }
        }
        return instance;
    }

    public void displayConfig() {
        System.out.println("=== Configuration Base de Données ===");
        System.out.println("URL: " + databaseUrl);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Max Connections: " + maxConnections);
    }
}
