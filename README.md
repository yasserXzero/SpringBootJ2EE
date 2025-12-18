# Gestion Commerciale par Points de Vente
### J2EE & Microservices – Spring Boot

## 📌 Description
Ce projet implémente un système de **gestion commerciale par points de vente** basé sur une architecture **J2EE distribuée et orientée microservices**.

Il est composé de trois applications indépendantes :
- `gestion_vente` (Application J2EE – MVC – JWT)
- `gestion_stock` (Microservice REST)
- `gestion_commercial` (Microservice REST)

Chaque application possède sa propre base de données MySQL et communique via des Web Services REST.

---

## 🧱 Architecture Générale

gestion_vente

├── REST → gestion_stock

└── REST → gestion_commercial

## ⚙️ Technologies Utilisées

- Java 17+
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security (JWT)
- REST / JSON
- MySQL
- JSP
- Maven

---

##  Microservices

###  gestion_stock
**Rôle :**
- Gestion des quantités en stock

**Endpoints :**
- `GET /stock` → Liste du stock
- `POST /stock/soustraire` → Soustraction de la quantité commandée

---

###  gestion_commercial
**Rôle :**
- Gestion centralisée des produits et des commandes

**Endpoints :**
- `GET /commercial/produits` → Produits et prix
- `POST /commercial/commande` → Ajout dans Tous_Commandes

---

###  gestion_vente
**Rôle :**
- Interface utilisateur
- Gestion des commandes
- Sécurité et authentification
- Génération de factures PDF

**Fonctionnalités :**
- Authentification JWT
- Consultation des produits
- Ajout de commande
- Génération de facture PDF

---

##  Sécurité (JWT)

- Authentification via login/mot de passe
- Mot de passe haché avec BCrypt
- JWT généré après connexion
- Token stocké dans la session HTTP
- Filtre JWT pour protéger les routes

---

##  Installation & Lancement

### Prérequis
- Java 17+
- MySQL
- Maven

### Étapes
1. Créer les bases de données MySQL
2. Configurer `application.properties` pour chaque service
3. Lancer les applications dans l’ordre :
   - gestion_stock
   - gestion_commercial
   - gestion_vente
4. Accéder à l’application :
http://localhost:8080/auth

---

##  Auteur
Projet réalisé dans le cadre du module **J2EE & Microservices – EMSI**.
KHARROUB YASSER


