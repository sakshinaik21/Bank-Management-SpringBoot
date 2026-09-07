# 🏦 Bankify – Bank Management System

Bankify is a **Bank Management System** developed using **Java and Spring Boot**. The application provides REST APIs to manage banks and their associated accounts, with data stored and managed using **PostgreSQL** and **Spring Data JPA**.

The project demonstrates backend development concepts such as **REST API development, CRUD operations, JPA/Hibernate, entity relationships, service-layer architecture, and database integration**.

---

## 🚀 Features

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

---

## 🛠️ Technologies Used

| Technology          | Purpose                     |
| ------------------- | --------------------------- |
| **Java**            | Backend programming         |
| **Spring Boot**     | Application development     |
| **Spring Data JPA** | Database operations         |
| **Hibernate**       | ORM                         |
| **PostgreSQL**      | Database                    |
| **Lombok**          | Reduces boilerplate code    |
| **Maven**           | Dependency management       |
| **REST API**        | Client-server communication |
| **Postman**         | API testing                 |
| **Git & GitHub**    | Version control             |

---

## 🏗️ Project Architecture

The project follows a layered architecture:

```text
Client / Postman
       ↓
Controller Layer
       ↓
Service Layer
       ↓
Repository Layer
       ↓
PostgreSQL Database
```

### Controller Layer

Handles HTTP requests and exposes REST API endpoints.

* `BankController`
* `AccountController`

### Service Layer

Contains the application's business logic.

* `BankService`
* `AccountService`

### Repository Layer

Handles database operations using Spring Data JPA.

* `BankRepository`
* `AccountRepository`

### Entity Layer

Contains the database entities and their relationships.

* `Bank`
* `Account`
* `Address`
* `AccountType`

---

## 📂 Project Structure

```text
Bank-Management-SpringBoot
│
├── src
│   └── main
│       ├── java
│       │   └── jsp_springBoot
│       │       ├── Controller
│       │       │   ├── BankController.java
│       │       │   └── AccountController.java
│       │       │
│       │       ├── Entity
│       │       │   ├── Bank.java
│       │       │   ├── Account.java
│       │       │   ├── Address.java
│       │       │   └── AccountType.java
│       │       │
│       │       ├── Repository
│       │       │   ├── BankRepository.java
│       │       │   └── AccountRepository.java
│       │       │
│       │       ├── Service
│       │       │   ├── BankService.java
│       │       │   └── AccountService.java
│       │       │
│       │       └── BankManagementApplication.java
│       │
│       └── resources
│           └── application.properties
│
├── pom.xml
└── README.md
```

---

## 🗄️ Database

The project uses **PostgreSQL** as the database.

Example database configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bank_management
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> Replace the username and password with your local PostgreSQL credentials.

---

## 🔗 Entity Relationships

The application models the relationship between banks and accounts.

```text
Bank
 │
 └── Accounts
       ├── Account Number
       ├── Account Type
       ├── Balance
       └── Address
```

An account is associated with a particular bank using the bank relationship defined in the entity model.

---

## 🌐 REST API Endpoints

### Bank APIs

| Method   | Endpoint      | Description         |
| -------- | ------------- | ------------------- |
| `GET`    | `/banks`      | Get all banks       |
| `GET`    | `/banks/{id}` | Get bank by ID      |
| `POST`   | `/banks`      | Create a new bank   |
| `PUT`    | `/banks/{id}` | Update bank details |
| `DELETE` | `/banks/{id}` | Delete a bank       |

### Account APIs

| Method   | Endpoint                  | Description                  |
| -------- | ------------------------- | ---------------------------- |
| `GET`    | `/accounts`               | Get all accounts             |
| `GET`    | `/accounts/{id}`          | Get account by ID            |
| `POST`   | `/accounts/bank/{bankId}` | Create an account for a bank |
| `POST`   | `/accounts/bulk`          | Create multiple accounts     |
| `PUT`    | `/accounts/{id}`          | Update account details       |
| `DELETE` | `/accounts/{id}`          | Delete an account            |

> Endpoint names can be adjusted if your final controller mappings use slightly different paths.

---
## 🧪 API Testing

The APIs were tested using **Postman**.

Testing included:

* Creating banks
* Retrieving bank details
* Creating accounts
* Associating accounts with banks
* Retrieving account information
* Updating records
* Deleting records
* Testing bulk account creation
* Validating JSON request and response data

---

## 💡 Key Concepts Demonstrated

This project helped demonstrate practical knowledge of:

* Java OOP
* Spring Boot
* RESTful Web Services
* CRUD operations
* Spring Data JPA
* Hibernate ORM
* Entity relationships
* Repository pattern
* Service-layer architecture
* Dependency Injection
* PostgreSQL database integration
* JSON serialization/deserialization
* API testing with Postman
* Maven
* Git and GitHub

---

## 📌 Future Improvements

The project can be further enhanced by adding:

* User authentication and authorization
* Spring Security
* JWT authentication
* Transaction management
* Deposit and withdrawal functionality
* Fund transfer between accounts
* Transaction history
* Account balance validation
* Global exception handling
* DTOs and validation
* Swagger/OpenAPI documentation
* Frontend dashboard

---

## 👩‍💻 Author

**Sakshi Naik**

B.E. – Electronics and Communication Engineering

Interested in **Java Backend / Full Stack Development**.

---

## ⭐ Project Highlights

**Bankify** is a backend-focused Spring Boot project created to gain hands-on experience in developing real-world REST APIs, connecting applications to PostgreSQL, and implementing a layered Spring Boot architecture.

If you find this project useful, feel free to ⭐ the repository.

