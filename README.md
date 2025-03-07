# 📚 Online Bookstore System

![Banner](https://images.unsplash.com/photo-1512820790803-83ca734da794?q=80&w=1498&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D)

A microservices-based Online Bookstore System built with **Spring Boot**, **Spring Cloud**, **Spring Security**, **Netflix Eureka**, and **MySQL**. This project demonstrates a distributed system with service discovery, API Gateway, and inter-service communication, featuring book management, order processing, and inventory tracking.

![GitHub](https://img.shields.io/github/license/lakshay1341/online-bookstore) ![GitHub Pages](https://img.shields.io/badge/GitHub%20Pages-Active-brightgreen) ![Build Status](https://img.shields.io/badge/build-passing-brightgreen)

## 🚀 Features
- **Microservices Architecture**: Separate services for books, orders, and inventory.
- **Service Discovery**: Netflix Eureka for dynamic service registration and discovery.
- **API Gateway**: Centralized routing with Spring Cloud Gateway.
- **Database**: MySQL for persistent storage with JPA/Hibernate.
- **API Documentation**: Swagger UI for API exploration.
- **Testing**: Comprehensive API tests with Postman.

## 🌐 Hosted Documentation
A static version of the API documentation is hosted on GitHub Pages: [Online Bookstore API Docs](https://lakshay1341.github.io/online-bookstore/)


## 🏗️ Architecture
The system consists of the following microservices:
- **Eureka Server**: Service registry for discovery.
- **API Gateway**: Entry point for all client requests.
- **Book Service**: Manages book CRUD operations.
- **Order Service**: Handles order creation and management.
- **Inventory Service**: Tracks book stock levels.

## 🛠️ Setup Instructions
### Prerequisites
- Java 17
- Maven
- MySQL
- Postman (for API testing)

### Steps
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/lakshay1341/online-bookstore.git
   cd online-bookstore
   
2. **Set Up the Database**:
  - Create a MySQL database named `bookstoredb`.

3. **Access the Application**:
   - Eureka Dashboard: [http://localhost:8761](http://localhost:8761)
   - API Gateway: [http://localhost:8080](http://localhost:8080)
   - Swagger UI for each service:
     - Book Service: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
     - Order Service: [http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)
     - Inventory Service: [http://localhost:8083/swagger-ui.html](http://localhost:8083/swagger-ui.html)

## 📖 API Documentation
### Swagger UI
Explore the API endpoints using Swagger UI:
- [Book Service Swagger](http://localhost:8081/swagger-ui.html)
- [Order Service Swagger](http://localhost:8082/swagger-ui.html)
- [Inventory Service Swagger](http://localhost:8083/swagger-ui.html)

Screenshots of Swagger UI:
- Book Service: ![Book Service Swagger](https://github.com/lakshay1341/online-bookstore/blob/main/docs/books_swagger.png)
- Order Service: ![Order Service Swagger](https://github.com/lakshay1341/online-bookstore/blob/main/docs/orders_swagger.png)
- Inventory Service: ![Inventory Service Swagger](https://github.com/lakshay1341/online-bookstore/blob/main/docs/inventory_swagger.png)

## 📸 Screenshots
### Eureka Dashboard
![Eureka Dashboard](https://github.com/lakshay1341/online-bookstore/blob/main/docs/eureka_dashboard.png)

### Postman Tests
![Postman Test - GET /books](https://github.com/lakshay1341/online-bookstore/blob/main/docs/postman_get_books.png)

## 🧪 Running API
Login:
   - `baseUrl`: `http://localhost:8080`
   - `username`: `admin`
   - `password`: `password`

## 📜 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📧 Contact
For questions or feedback, reach out to me at [lakshaychaudhary2003@gmail.com](mailto:lakshaychaudhary2003@gmail.com).
  
