# E-Library-Management-System


A robust backend-driven **E-Library Management System** built using **Java**, **Spring Boot**, and **MySQL**, designed to manage books, students, and admin operations efficiently with secure authentication and caching support.

## Features

* Secure authentication and authorization using **Spring Security**
* Role-based access control (**Admin / Student**)
* Book management APIs
* Issue and return book system
* Student management
* Admin management
* Caching support using **Redis**
* API documentation using **Swagger UI**
* RESTful API architecture
* Database persistence using **JPA / Hibernate**
* Book reservation
* JWT authentication

---

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate

### Database

* MySQL

### Cache

* Redis

### API Documentation

* Swagger / OpenAPI

### Build Tool

* Maven

---

## Project Structure

```text
src/main/java
│── config/cache/security
│── controller
│── service
│── repository
│── model/enums/request
│── dto
│── constant 
```

---

## Authentication

The system uses **Spring Security** with BCrypt password encryption.

### Default Seed Users

#### Admin

```text
Username: krishna
Password: krishna123
```

#### Student

```text
Username: radha
Password: radha123
```

---

## API Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

API Docs JSON:

```text
http://localhost:8080/v3/api-docs
```

---

## Database Setup

1. Create database:

```sql
CREATE DATABASE minor_project;
```

2. Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/minor_project
spring.datasource.username=your_username
spring.datasource.password=your_password
```

---

## Redis Setup

Run Redis locally:

```bash
redis-server
```
Verify:

```bash
redis-cli ping
```
Expected:
```text
PONG
```

Update Redis config:

```java
new RedisStandaloneConfiguration("localhost",6379);
```

---

## Installation

Clone the repository:

```bash
git clone https://github.com/KrishnaSingh67/E-Library-Management-System.git
```

Move into project directory:

```bash
cd E-Library-Management-System
```

Install dependencies:

```bash
mvn clean install
```

Run application:

```bash
mvn spring-boot:run
```

---

## Core Functionalities

### Admin

* Add books
* Update books
* Delete books
* Manage students
* Issue books
* Return books

### Student

* View books
* Borrow books
* Return books
* Check account status

---

## Security Flow

```text
Login Request
    ↓
Spring Security Authentication
    ↓
Redis Cache Check
    ↓
MySQL Database Verification
    ↓
Role-based Authorization
```

---

## Future Improvements

* Email notifications
* Payment integration
* Analytics dashboard

---

## Learning Outcomes

This project demonstrates:

* Backend architecture design
* Authentication implementation
* Caching strategy
* Database relationship management
* API documentation
* Clean code practices

---

## Author
Krishna Singh

GitHub:
https://github.com/KrishnaSingh67
