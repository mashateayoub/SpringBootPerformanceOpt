# Performance API

## Overview

This project is a Spring Boot application designed for performance optimization. It provides endpoints to manage and retrieve book information, utilizing caching and asynchronous processing to enhance performance.

## Features

- **CRUD Operations**: Create, Read, Update, and Delete operations for books.
- **Caching**: Utilizes Redis for caching book data to improve response times.
- **Asynchronous Processing**: Supports asynchronous retrieval of book data.
- **PostgreSQL Database**: Uses PostgreSQL as the data store.

## Technologies Used

- Java 17
- Spring Boot 3.3.4
- Spring Data JPA
- Redis
- PostgreSQL
- Lombok
- Maven

## Getting Started

### Prerequisites

- Java 17
- Maven
- PostgreSQL
- Redis

### Installation

1. Clone the repository:

   ```bash
   git clone <repository-url>
   cd performance
   ```

2. Configure the database:

   - Create a PostgreSQL database named `API_PERFORMANCE`.
   - Update the `application.yml` file with your PostgreSQL credentials.

3. Start a Redis server.

4. Build the project:

   ```bash
   mvn clean install
   ```

5. Run the application:

   ```bash
   mvn spring-boot:run
   ```

### API Endpoints

- **Get All Books**: `GET /api/books`
- **Get Book by ID**: `GET /api/books/{id}`
- **Get All Books Asynchronously**: `GET /api/books/async`

## Configuration

The application configuration can be found in `src/main/resources/application.yml`. You can modify the Redis and PostgreSQL settings as needed.

## Running Tests

To run the tests, use the following command:
```bash
mvn test
```

