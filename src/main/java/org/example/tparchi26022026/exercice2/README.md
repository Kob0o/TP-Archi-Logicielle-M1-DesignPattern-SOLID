# Exercice 2 : SOLID Principles

Refactorisation de code problématique pour respecter les 5 principes SOLID.

## Structure

```
exercice2/
└── solid/
    ├── s/  (Single Responsibility)
    ├── o/  (Open/Closed)
    ├── l/  (Liskov Substitution)
    ├── i/  (Interface Segregation)
    └── d/  (Dependency Inversion)
```

Chaque principe contient un dossier `problem/` et un dossier `solution/`.

---

## 1. Single Responsibility Principle (SRP)

### Problème
`UserManager` a trop de responsabilités : gestion, validation, notification, persistance.

### Solution
Séparation en 4 classes :
- `UserRepository` : gestion des utilisateurs
- `UserValidator` : validation
- `NotificationService` : notifications
- `DatabaseService` : persistance
- `UserService` : orchestration

---

## 2. Open/Closed Principle (OCP)

### Problème
`BookRater` utilise un switch/case, nécessite modification pour ajouter un type.

### Solution
Strategy Pattern avec interface `RatingStrategy` et implémentations :
- `FictionRatingStrategy`
- `ScienceRatingStrategy`
- `HistoryRatingStrategy`

Ajout d'un nouveau type sans modifier `BookRater`.

---

## 3. Liskov Substitution Principle (LSP)

### Problème
`Ostrich` hérite de `Bird` mais ne peut pas voler, viole le contrat.

### Solution
Séparation des responsabilités :
- `Bird` : classe abstraite avec `eat()`
- `Flyable` : interface pour les oiseaux qui volent
- `Sparrow` : implémente `Bird` et `Flyable`
- `Ostrich` : implémente seulement `Bird`

---

## 4. Interface Segregation Principle (ISP)

### Problème
Interface `Book` trop large, force `EBook` à implémenter des méthodes inutiles.

### Solution
Interfaces ségrégées :
- `BookInfo` : titre et auteur
- `EReadable` : méthodes pour e-books
- `Printable` : méthodes pour livres imprimés
- `Loanable` : gestion des emprunts

`EBook` et `PrintedBook` n'implémentent que ce dont elles ont besoin.

---

## 5. Dependency Inversion Principle (DIP)

### Problème
`OrderService` dépend de classes concrètes, difficile à tester.

### Solution
Injection de dépendances via interfaces :
- `NotificationService` : EmailNotificationService, SmsNotificationService
- `DataRepository` : DatabaseRepository, FileRepository

`OrderService` dépend des abstractions, facilement testable avec des mocks.
