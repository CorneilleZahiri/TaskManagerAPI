# Cahier Technique – Task Manager API

## 1. Présentation du projet

### Objectif

Développer une application de gestion de tâches permettant à un utilisateur de :

* Créer une tâche
* Consulter une tâche
* Consulter toutes les tâches
* Modifier une tâche
* Supprimer une tâche
* Changer le statut d'une tâche

Le projet servira de support pratique pour l'apprentissage de :

* Spring Boot
* PostgreSQL
* JPA/Hibernate
* Validation
* Tests unitaires
* Docker
* GitHub Actions
* CI/CD
* Déploiement

---

# 2. Architecture

## Backend

Technologies :

* Java 21
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* JUnit 5
* Mockito

## Frontend

Technologies :

* React
* TypeScript
* Axios

## DevOps

* Docker
* Docker Compose
* GitHub Actions

---

# 3. Modèle de données

## Entité Task

| Champ       | Type          | Contraintes                     |
| ----------- | ------------- | ------------------------------- |
| id          | Long          | PK, Auto généré                 |
| title       | String        | Obligatoire, max 100 caractères |
| description | String        | Facultatif                      |
| status      | Enum          | Obligatoire                     |
| createdAt   | LocalDateTime | Généré automatiquement          |
| updatedAt   | LocalDateTime | Mis à jour automatiquement      |

---

# 4. Enum Status

Valeurs possibles :

```text
TODO
IN_PROGRESS
DONE
```

Description :

* TODO : tâche créée mais non démarrée
* IN_PROGRESS : tâche en cours
* DONE : tâche terminée

---

# 5. API REST

## Base URL

```http
/api/tasks
```

---

# 5.1 Créer une tâche

## Endpoint

```http
POST /api/tasks
```

## Request Body

```json
{
  "title": "Préparer le pipeline CI",
  "description": "Créer GitHub Actions"
}
```

## Réponse

```json
{
  "id": 1,
  "title": "Préparer le pipeline CI",
  "description": "Créer GitHub Actions",
  "status": "TODO",
  "createdAt": "2026-06-15T10:00:00"
}
```

## Code HTTP

```text
201 CREATED
```

---

# 5.2 Récupérer toutes les tâches

## Endpoint

```http
GET /api/tasks
```

## Réponse

```json
[
  {
    "id": 1,
    "title": "Préparer le pipeline CI",
    "description": "Créer GitHub Actions",
    "status": "TODO"
  },
  {
    "id": 2,
    "title": "Dockeriser l'application",
    "description": "Créer le Dockerfile",
    "status": "IN_PROGRESS"
  }
]
```

## Code HTTP

```text
200 OK
```

---

# 5.3 Récupérer une tâche

## Endpoint

```http
GET /api/tasks/{id}
```

## Exemple

```http
GET /api/tasks/1
```

## Réponse

```json
{
  "id": 1,
  "title": "Préparer le pipeline CI",
  "description": "Créer GitHub Actions",
  "status": "TODO"
}
```

## Code HTTP

```text
200 OK
```

---

# 5.4 Modifier une tâche

## Endpoint

```http
PUT /api/tasks/{id}
```

## Request Body

```json
{
  "title": "Pipeline GitHub Actions",
  "description": "Créer le workflow CI",
  "status": "IN_PROGRESS"
}
```

## Réponse

```json
{
  "id": 1,
  "title": "Pipeline GitHub Actions",
  "description": "Créer le workflow CI",
  "status": "IN_PROGRESS"
}
```

## Code HTTP

```text
200 OK
```

---

# 5.5 Modifier uniquement le statut

## Endpoint

```http
PATCH /api/tasks/{id}/status
```

## Request Body

```json
{
  "status": "DONE"
}
```

## Réponse

```json
{
  "id": 1,
  "title": "Pipeline GitHub Actions",
  "description": "Créer le workflow CI",
  "status": "DONE"
}
```

## Code HTTP

```text
200 OK
```

---

# 5.6 Supprimer une tâche

## Endpoint

```http
DELETE /api/tasks/{id}
```

## Exemple

```http
DELETE /api/tasks/1
```

## Code HTTP

```text
204 NO CONTENT
```

---

# 6. Gestion des erreurs

## Ressource introuvable

```json
{
  "timestamp": "2026-06-15T12:00:00",
  "status": 404,
  "message": "Task not found"
}
```

Code :

```text
404 NOT FOUND
```

---

## Validation

```json
{
  "timestamp": "2026-06-15T12:00:00",
  "status": 400,
  "message": "Title is required"
}
```

Code :

```text
400 BAD REQUEST
```

---

# 7. Tests à implémenter

## Service

* createTask()
* getTaskById()
* getAllTasks()
* updateTask()
* deleteTask()

## Controller

* POST /tasks
* GET /tasks
* GET /tasks/{id}
* PUT /tasks/{id}
* DELETE /tasks/{id}

---

# 8. Docker

## Backend

Construction :

```bash
docker build -t task-manager-backend .
```

Exécution :

```bash
docker run -p 8080:8080 task-manager-backend
```

---

# 9. CI/CD

Pipeline GitHub Actions :

1. Checkout code
2. Setup Java
3. Run tests
4. Build application
5. Build Docker image
6. Push Docker image
7. Deploy

---

# 10. Évolutions futures

* Authentification JWT
* Gestion des utilisateurs
* Attribution des tâches
* Pagination
* Recherche multicritère
* Swagger/OpenAPI
* Monitoring
* Kubernetes
* Déploiement Cloud
