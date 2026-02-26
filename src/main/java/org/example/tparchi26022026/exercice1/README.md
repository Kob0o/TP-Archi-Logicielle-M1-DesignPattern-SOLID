# Exercice 1 : Design Patterns Fondamentaux

Cet exercice implémente les 4 design patterns fondamentaux dans le contexte d'une plateforme de gestion de bibliothèque.

## Structure

```
exercice1/
├── builder/          # Builder Pattern
├── factory/          # Factory Pattern
├── singleton/        # Singleton Pattern
└── prototype/        # Prototype Pattern
```

---

## 1. Builder Pattern

### Fichiers
- `Book.java` : Classe Book avec Builder interne
- `BookBuilderDemo.java` : Démonstration du pattern

### Objectif
Construire des objets `Book` complexes avec de nombreux attributs optionnels (auteur, éditeur, ISBN, tags, etc.) de manière fluide et lisible.


### Avantages
- API fluide et lisible
- Paramètres optionnels faciles à gérer
- Évite les constructeurs avec trop de paramètres
- Validation possible avant le build()

---

## 2. Factory Pattern

### Fichiers
- `NotificationService.java` : Interface commune
- `EmailNotificationService.java`, `SmsNotificationService.java`, `PushNotificationService.java` : Implémentations
- `EmailNotificationFactory.java`, `SmsNotificationFactory.java`, `PushNotificationFactory.java` : Approche A (Multiple Factories)
- `NotificationFactory.java` : Approche B (Simple Factory)
- `FactoryPatternDemo.java` : Démonstration des deux approches

### Objectif
Créer des services de notification différents (Email, SMS, Push) sans que le client connaisse les classes concrètes.


### Comparaison
- **Approche A** : Plus flexible pour des factories complexes, mais plus de classes à maintenir
- **Approche B** : Plus simple et centralisé, facile à étendre (ajouter un case)

---

## 3. Singleton Pattern

### Fichiers
- `DatabaseConfig.java` : Singleton avec Lazy Initialization (thread-safe)
- `LibraryConfig.java` : Singleton utilisant un Enum
- `SingletonPatternDemo.java` : Démonstration des deux approches

### Objectif
Assurer qu'une classe n'a qu'une seule instance dans l'application (configuration de la bibliothèque, connexions DB).

### Approche 1 : Lazy Initialization

**Caractéristiques :**
- Instance créée uniquement si nécessaire
- Thread-safe avec double-check locking
- Peut être étendue (héritage possible)

### Approche 2 : Enum Singleton

**Caractéristiques :**
- Thread-safe par défaut
- Sérialisation automatique
- Protection contre la réflexion
- Code plus simple et concis
- **Recommandé en Java**

### Pourquoi l'Enum Singleton est supérieur ?
L'Enum Singleton garantit automatiquement l'unicité, la thread-safety, et la protection contre la sérialisation et la réflexion, sans code supplémentaire.

---

## 4. Prototype Pattern

### Fichiers
- `UserPreferences.java` : Classe avec clonage profond (deep copy)
- `PrototypePatternDemo.java` : Démonstration du pattern

### Objectif
Cloner les configurations de lecture d'un lecteur existant pour créer un nouveau profil sans connaître les détails d'implémentation.


### Deep Copy
La méthode `clone()` implémente une **deep copy** :
- Crée de nouvelles listes avec les mêmes éléments
- Les modifications sur le clone n'affectent pas l'original
- Chaque utilisateur a ses propres préférences sans partage de références

### Pourquoi une Deep Copy est importante ?
1. Crée des copies indépendantes des objets complexes (listes, etc.)
2. Les modifications sur le clone n'affectent pas l'original
3. Chaque utilisateur a ses propres préférences sans partage de références
4. Évite les effets de bord et les bugs difficiles à détecter

---

## Questions de Réflexion

1. **Builder Pattern** : Quel est l'avantage du Builder par rapport à un constructeur avec 10 paramètres ?
   - Réponse : API fluide, paramètres optionnels, validation possible, code plus lisible

2. **Factory Pattern** : Quelle approche est plus flexible pour ajouter un nouveau type de notification ?
   - Réponse : L'approche B (Simple Factory) car il suffit d'ajouter un case dans le switch

3. **Singleton Pattern** : Pourquoi l'Enum Singleton est-il supérieur au Singleton classique ?
   - Réponse : Thread-safety native, sérialisation automatique, protection contre la réflexion

4. **Prototype Pattern** : Pourquoi une deep copy est-elle importante ici ?
   - Réponse : Pour éviter les références partagées et garantir l'indépendance des copies
