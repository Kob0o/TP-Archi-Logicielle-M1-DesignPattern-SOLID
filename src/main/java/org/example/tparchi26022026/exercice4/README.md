# Exercice 4 : Migration vers Microservices

Architecture microservices avec 4 services indépendants et un API Gateway.

## Architecture

```
API Gateway (8080)
    ├── Book Service (8081)
    ├── User Service (8082)
    ├── Loan Service (8083)
    └── Review Service (8084)
```

## Services

### Book Service (Port 8081)
- Gestion des livres
- Base de données H2 : `bookdb`
- Endpoints : `/api/books`

### User Service (Port 8082)
- Gestion des utilisateurs
- Base de données H2 : `userdb`
- Endpoints : `/api/users`

### Loan Service (Port 8083)
- Gestion des emprunts
- Base de données H2 : `loandb`
- Endpoints : `/api/loans`
- Communication avec Book Service et User Service

### Review Service (Port 8084)
- Gestion des critiques
- Base de données H2 : `reviewdb`
- Endpoints : `/api/reviews`
- Communication avec Book Service et User Service

### API Gateway (Port 8080)
- Point d'entrée unique
- Route les requêtes vers les services appropriés
- Endpoints : `/api/*`

## Communication Inter-Services

- **Loan Service** appelle Book Service et User Service pour valider les IDs
- **Review Service** appelle Book Service et User Service pour valider les IDs
- Communication via **RestTemplate** avec URLs configurées

## Avantages des Microservices

- **Indépendance** : Chaque service peut être déployé indépendamment
- **Scalabilité** : Mise à l'échelle indépendante de chaque service
- **Technologies** : Possibilité d'utiliser différentes technologies par service
- **Isolation** : Une panne dans un service n'affecte pas les autres

## Inconvénients

- **Complexité** : Plus complexe à gérer qu'un monolithe
- **Réseau** : Communication réseau entre services (latence)
- **Déploiement** : Plus de services à déployer et monitorer
- **Consistance** : Gestion de la cohérence des données distribuées
