# Task Management API

Una semplice API REST per la gestione di progetti e attività (*Task Management*), sviluppata con Spring Boot e MyBatis-Plus.

Il progetto nasce con l'obiettivo di mettere in pratica le competenze fondamentali nello sviluppo backend Java, attraverso la creazione di API REST, la gestione di un database relazionale e l'organizzazione del codice secondo un'architettura a livelli.

## Tecnologie utilizzate

- **Java** – Linguaggio di programmazione.
- **Spring Boot** – Framework per lo sviluppo backend.
- **Spring Web** – Creazione delle API REST.
- **MyBatis-Plus** – Framework per l'accesso e la gestione dei dati.
- **MySQL** – Database relazionale.
- **Maven** – Gestione delle dipendenze e compilazione.
- **Postman** – Test delle API REST.

## Funzionalità del progetto

L'applicazione permette di gestire progetti e le relative attività.

### Gestione dei progetti (Project)

- Creazione di un nuovo progetto.
- Visualizzazione di tutti i progetti.
- Ricerca di un progetto tramite ID.
- Modifica di un progetto esistente.
- Eliminazione di un progetto.

### Gestione delle attività (Task)

- Creazione di nuove attività.
- Visualizzazione di tutte le attività.
- Ricerca di un'attività tramite ID.
- Modifica di un'attività.
- Eliminazione di un'attività.
- Gestione dello stato delle attività.
- Visualizzazione delle attività associate a un progetto.

## Struttura del database

Il database è composto da due tabelle principali:

### Project

| Campo | Descrizione |
|---|---|
| id | Identificativo del progetto |
| name | Nome del progetto |
| description | Descrizione del progetto |

### Task

| Campo | Descrizione |
|---|---|
| id | Identificativo dell'attività |
| title | Titolo dell'attività |
| description | Descrizione dell'attività |
| status | Stato dell'attività |
| project_id | Identificativo del progetto associato |

**Relazione:** un progetto può contenere più attività, mentre ogni attività appartiene a un solo progetto (One-to-Many).

Gli stati disponibili per un'attività sono:

- `TODO`
- `IN_PROGRESS`
- `COMPLETED`

### API REST

## Project API

| Metodo HTTP | Endpoint | Descrizione |
|---|---|---|
| POST | `/api/projects` | Crea un nuovo progetto |
| GET | `/api/projects` | Recupera tutti i progetti |
| GET | `/api/projects/{id}` | Recupera un progetto tramite ID |
| PUT | `/api/projects/{id}` | Modifica un progetto |
| DELETE | `/api/projects/{id}` | Elimina un progetto |

## Task API

| Metodo HTTP | Endpoint | Descrizione |
|---|---|---|
| POST | `/api/projects/{projectId}/tasks` | Crea un'attività associata a un progetto |
| GET | `/api/tasks` | Recupera tutte le attività |
| GET | `/api/tasks/{id}` | Recupera un'attività tramite ID |
| PUT | `/api/tasks/{id}` | Modifica un'attività |
| DELETE | `/api/tasks/{id}` | Elimina un'attività |
| GET | `/api/projects/{projectId}/tasks` | Recupera tutte le attività di un progetto |
| PATCH | `/api/tasks/{id}/status` | Aggiorna lo stato di un'attività |


