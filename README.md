# Serveur Web Multi-threadé Java

Un serveur web HTTP simple implémenté en Java utilisant les sockets TCP/IP, la programmation multi-threadée et un pool de threads pour gérer les requêtes concurrentes.

## 🎯 Concepts utilisés

### **Programmation réseau avec Sockets**
- **Socket TCP/IP** : Établit des connexions HTTP entre le serveur et les clients web
- **ServerSocket** : Écoute les connexions entrantes sur le port 8080
- **OutputStream/BufferedReader** : Gestion des flux HTTP pour les requêtes et réponses

### **Pool de Threads (Thread Pool)**
- **ExecutorService** : Gère un pool fixe de 10 threads pour traiter les requêtes
- **Executors.newFixedThreadPool(10)** : Limite le nombre de threads actifs et réutilise les threads
- **Performance optimisée** : Évite la création/destruction constante de threads

### **Protocole HTTP**
- **Parsing des requêtes HTTP** : Lecture des headers et du corps de la requête
- **Réponse HTTP standardisée** : Status code, headers et contenu
- **Content-Type et Content-Length** : Headers appropriés pour la réponse

### **Architecture Multi-threadée**
- **Thread principal** : Accepte les connexions en continu
- **Threads workers** : Chaque requête HTTP est traitée dans un thread du pool
- **Traitement concurrent** : Plusieurs requêtes peuvent être traitées simultanément

### **Gestion des ressources**
- **Try-with-resources** : Fermeture automatique des sockets et flux
- **Gestion des exceptions** : Traitement propre des erreurs de connexion et I/O
- **Thread.join()** : Attente propre de la fin du thread serveur

## 🏗️ Architecture

```
MultithreadedWebServer
├── Écoute sur le port 8080
├── Pool de 10 threads workers
└── Distribue les requêtes via ExecutorService

ClientHandler (un par requête)
├── Traite une requête HTTP complète
├── Parse les headers HTTP
├── Génère une réponse HTTP 200 OK
└── Ferme la connexion

MainTest
├── Lance le serveur sur un thread dédié
└── Attend la fin d'exécution avec join()
```

## 🚀 Installation et exécution

### Prérequis
- Java JDK 8 ou supérieur
- Un navigateur web ou un outil comme curl/Postman

### Compilation
```bash
javac *.java
```

### Exécution

#### Lancer le serveur
```bash
java MainTest
```

Le serveur démarre automatiquement sur le port 8080.

## 📝 Utilisation

### Accès via navigateur
1. **Démarrer le serveur** : `java MainTest`
2. **Ouvrir le navigateur** : Aller à `http://localhost:8080`
3. **Voir la réponse** : "Hello World" s'affiche dans le navigateur

### Accès via curl
```bash
curl http://localhost:8080
# Retourne: Hello World
```

### Test de charge
```bash
# Plusieurs requêtes simultanées
for i in {1..20}; do curl http://localhost:8080 & done
```

## 🔧 Fonctionnalités

- **Serveur HTTP fonctionnel** répondant aux requêtes GET
- **Gestion de 10 connexions simultanées** grâce au pool de threads
- **Réponse HTTP standardisée** avec headers appropriés
- **Parsing des requêtes HTTP** (lecture des headers)
- **Gestion propre des connexions** avec fermeture automatique

## 📚 Points d'apprentissage

Ce projet illustre parfaitement :
- **Les bases du protocole HTTP** (requêtes/réponses)
- **L'utilisation des pools de threads** pour optimiser les performances
- **La programmation réseau** avec les sockets Java
- **La gestion de la concurrence** sans synchronisation explicite
- **L'architecture client-serveur** web classique
- **Les bonnes pratiques** de gestion des ressources système

## 🚀 Extensions possibles

- Ajouter le support des méthodes POST, PUT, DELETE
- Servir des fichiers statiques (HTML, CSS, JS)
- Ajouter un système de routing
- Implémenter le support HTTPS
- Ajouter des logs détaillés des requêtes