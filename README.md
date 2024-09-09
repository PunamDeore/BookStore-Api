
# Bookstore Management System API

## Description

The Bookstore Management System API is a RESTful backend application developed using Java and Spring Boot. This system provides a robust and scalable solution for managing books, authors, and orders in a bookstore. It features role-based access control, allowing different levels of access for Admin, Manager, and Customer roles.

## Features

- **Books Management**: 
  - Add, update, and delete books.
  - Retrieve book details and list of books.

- **Authors Management**: 
  - Add, update, and delete authors.
  - Retrieve author details and list of authors.

- **Orders Management**: 
  - Place new orders.
  - Update and cancel existing orders.
  - Retrieve order details and list of orders.

- **Role-Based Access Control**:
  - **Admin**: Full access to manage books, authors, and orders.
  - **Manager**: Limited access to manage books and view orders.
  - **Customer**: View books and place orders.

- **JWT Authentication**: Secure access to the API using JSON Web Tokens (JWT) for user authentication and role-based authorization.

- **API Documentation**: 
  - Interactive API documentation available via Swagger UI.
  - API endpoints are described and tested through Swagger.

## Technology Stack

- **Java**: Programming language used for backend development.
- **Spring Boot**: Framework for building the RESTful API.
- **PostgreSQL**: Database for storing book, author, and order data.
- **Spring Security**: For implementing role-based access control and JWT authentication.
- **Swagger**: For API documentation and interactive testing.

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- PostgreSQL 42.5.4
- Docker (optional, for containerized setup)

## Setup

1. **Clone the Repository**


   git clone https://github.com/PunamDeore/BookStore-Api.git
   cd BookStore-Api


2. **Configure Database**

   Update the `src/main/resources/application.properties` file with your PostgreSQL database credentials:


   spring.application.name=BookStore

   # DataSource configuration
   spring.datasource.url=jdbc:postgresql://localhost:5432/bookstore
   spring.datasource.username=postgres
   spring.datasource.password=1234

   # JPA/Hibernate configuration
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

   # Springdoc OpenAPI configuration
   springdoc.api-docs.path=/v3/api-docs
   springdoc.swagger-ui.path=/swagger-ui.html


3. **Build and Run the Application**

   Use Maven to build and run the application:


   mvn clean install
   mvn spring-boot:run


   The application will be accessible at `http://localhost:8080`.

## API Endpoints

- **Authentication**
  - `POST /auth/login`: Authenticate users and generate JWT tokens.

- **Books**
  - `GET /admin/books`: Retrieve all books.
  - `POST /admin/books`: Add a new book.
  - `PUT /admin/books/{id}`: Update an existing book.
  - `DELETE /admin/books/{id}`: Delete a book.

- **Authors**
  - `GET /admin/authors`: Retrieve all authors.
  - `POST /admin/authors`: Add a new author.
  - `PUT /admin/authors/{id}`: Update an existing author.
  - `DELETE /admin/authors/{id}`: Delete an author.

- **Orders**
  - `GET /customer/orders`: Retrieve all orders for a customer.
  - `POST /customer/orders`: Place a new order.
  - `PUT /customer/orders/{id}`: Update an existing order.
  - `DELETE /customer/orders/{id}`: Cancel an order.

## Docker

To build and run the Docker container:

1. **Build Docker Image**


   docker build -t bookstore-management-system .



- **API Testing**: Use tools like Postman to test the API endpoints.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new feature'`).
5. Push to the branch (`git push origin feature/your-feature`).
6. Create a Pull Request.

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.
