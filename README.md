# Serveur Web Multithreadé

Ce projet implémente un serveur web HTTP simple utilisant des techniques de programmation concurrente en Java.

## Concepts Démontrés

### 1. Programmation Réseau
- Utilisation des sockets pour la communication réseau (`ServerSocket`, `Socket`)
- Implémentation basique du protocole HTTP
- Gestion des connexions client-serveur

### 2. Programmation Concurrente
- Utilisation des threads pour gérer plusieurs clients simultanément
- Implémentation d'un pool de threads avec `ExecutorService`
- Utilisation de l'interface `Runnable` pour définir des tâches exécutables

### 3. Gestion des Ressources
- Utilisation de blocs try-with-resources pour garantir la fermeture des ressources
- Gestion appropriée des exceptions
- Fermeture propre des connexions client

### 4. Architecture Modulaire
- Séparation des responsabilités entre différentes classes:
  - `MultithreadedWebServer`: gestion du serveur et acceptation des connexions
  - `ClientHandler`: traitement des requêtes client individuelles
  - `MainTest`: point d'entrée de l'application

## Comment Exécuter

1. Compilez le projet avec votre IDE ou via la ligne de commande
2. Exécutez la classe `MainTest`
3. Le serveur démarrera sur le port 8080
4. Accédez au serveur depuis un navigateur web en visitant `http://localhost:8080`

## Points d'Apprentissage Clés

- **Concurrence vs Parallélisme**: Ce serveur démontre comment gérer plusieurs connexions clients simultanément grâce à un pool de threads.
- **Pattern Thread Pool**: Utilisation d'un pool de threads fixe (10 threads) pour limiter la consommation de ressources tout en permettant la concurrence.
- **Méthodes de Référence**: Utilisation de la syntaxe `server::startServer` pour créer une référence de méthode comme tâche de thread.
- **Gestion des E/S réseau**: Lecture et écriture de données sur les sockets réseau.

## Améliorations Possibles

- Implémentation d'un routeur pour gérer différentes URL
- Ajout de support pour différents types de contenu (HTML, JSON, etc.)
- Amélioration de la gestion des erreurs et journalisation
- Implémentation d'une gestion gracieuse de l'arrêt du serveur
- Tests de charge pour évaluer les performances