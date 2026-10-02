# 🏦 Bankify – Bank Management System

Bankify is a **Bank Management System** developed using **Java and Spring Boot**. The application provides REST APIs to manage banks and their associated accounts, with data stored and managed using **PostgreSQL** and **Spring Data JPA**.

The project demonstrates backend development concepts such as **REST API development, CRUD operations, JPA/Hibernate, entity relationships, service-layer architecture, database integration, and AI API integration**.

The application also includes an **AI Banking Assistant** that provides a chatbot interface through the frontend and communicates with the Spring Boot backend through a REST API.

---

## 🚀 Features

### 🏦 Banking Management

* Create and manage banks
* Create and manage bank accounts
* Associate accounts with banks
* Retrieve bank and account details
* Update account and bank information
* Delete bank and account records
* Support for different account types
* PostgreSQL database integration
* RESTful API architecture
* JSON-based request and response handling
* Bulk account creation
* Exception handling and validation

### 🤖 AI Banking Assistant

* AI chatbot interface integrated into the Bankify frontend
* User-friendly chatbot UI
* Spring Boot REST API for AI requests
* Frontend-to-backend communication using JavaScript Fetch API
* OpenAI API integration
* Error handling for unavailable AI services
* Banking-related questions can be submitted through the chatbot interface

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| **Java** | Backend programming |
| **Spring Boot** | Application development |
| **Spring Data JPA** | Database operations |
| **Hibernate** | ORM |
| **PostgreSQL** | Database |
| **Lombok** | Reduces boilerplate code |
| **Maven** | Dependency management |
| **REST API** | Client-server communication |
| **Postman** | API testing |
| **HTML5** | Frontend structure |
| **CSS3** | Frontend styling |
| **JavaScript** | Frontend functionality and API communication |
| **OpenAI API** | AI Banking Assistant integration |
| **Git & GitHub** | Version control |

---

## 🏗️ Project Architecture

The project follows a layered architecture:

```text
                    Bankify Frontend
                          │
             ┌────────────┴────────────┐
             │                         │
       Banking UI                AI Chatbot UI
             │                         │
             └────────────┬────────────┘
                          ↓
                  Spring Boot Backend
                          │
                  Controller Layer
                          │
                  Service Layer
                          │
                 Repository Layer
                    /          \
                   ↓            ↓
          PostgreSQL Database   OpenAI API

