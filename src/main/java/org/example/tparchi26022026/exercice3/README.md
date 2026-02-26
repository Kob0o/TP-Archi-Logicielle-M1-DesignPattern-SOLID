# Exercice 3 : Architecture Monolithique

Application Spring Boot complète en couches pour la gestion d'une bibliothèque.

## Structure

```
exercice3/
├── model/          # Entities JPA
├── dto/            # Data Transfer Objects
├── repository/     # Repositories JPA
├── service/        # Services (interfaces + implémentations)
├── controller/     # Contrôleurs REST
├── exception/      # Gestion des exceptions
├── util/           # Utilitaires (DTOMapper)
└── config/         # Configuration
```

## Endpoints REST

### Books
- `GET /api/books` - Liste tous les livres
- `GET /api/books/{id}` - Récupère un livre par ID
- `POST /api/books` - Crée un nouveau livre
- `PUT /api/books/{id}` - Met à jour un livre
- `DELETE /api/books/{id}` - Supprime un livre
- `GET /api/books/author/{author}` - Livres par auteur
- `GET /api/books/genre/{genre}` - Livres par genre

### Users
- `GET /api/users` - Liste tous les utilisateurs
- `GET /api/users/{id}` - Récupère un utilisateur par ID
- `GET /api/users/username/{username}` - Récupère par username
- `POST /api/users` - Crée un nouvel utilisateur
- `PUT /api/users/{id}` - Met à jour un utilisateur
- `DELETE /api/users/{id}` - Supprime un utilisateur

### Loans
- `GET /api/loans` - Liste tous les emprunts
- `GET /api/loans/{id}` - Récupère un emprunt par ID
- `POST /api/loans` - Crée un nouvel emprunt
- `PUT /api/loans/{id}/return` - Retourne un livre
- `GET /api/loans/user/{userId}` - Emprunts d'un utilisateur
- `GET /api/loans/book/{bookId}` - Emprunts d'un livre

### Reviews
- `GET /api/reviews` - Liste toutes les critiques
- `GET /api/reviews/{id}` - Récupère une critique par ID
- `POST /api/reviews` - Crée une nouvelle critique
- `PUT /api/reviews/{id}` - Met à jour une critique
- `DELETE /api/reviews/{id}` - Supprime une critique
- `GET /api/reviews/book/{bookId}` - Critiques d'un livre
- `GET /api/reviews/user/{userId}` - Critiques d'un utilisateur



L'application démarre sur le port 8080.

Console H2 : http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:librarydb`
- Username: `sa`
- Password: (vide)

## Architecture en couches

- **Controller** : Gère les requêtes HTTP
- **Service** : Logique métier
- **Repository** : Accès aux données
- **Model** : Entités JPA
- **DTO** : Objets de transfert de données

Cette séparation facilite la maintenance, les tests et l'évolution du code.
