# 📚 Online Bookstore System

![Banner](https://images.unsplash.com/photo-1512820790803-83ca734da794?q=80&w=1498&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D)

A microservices-based Online Bookstore System built with **Spring Boot**, **Spring Cloud**, **Netflix Eureka**, and **MySQL**. This project demonstrates a distributed system with service discovery, API Gateway, and inter-service communication, featuring book management, order processing, and inventory tracking.

![GitHub](https://img.shields.io/github/license/lakshay1341/online-bookstore) ![GitHub Pages](https://img.shields.io/badge/GitHub%20Pages-Active-brightgreen) ![Build Status](https://img.shields.io/badge/build-passing-brightgreen)

## 🚀 Features
- **Microservices Architecture**: Separate services for books, orders, and inventory.
- **Service Discovery**: Netflix Eureka for dynamic service registration and discovery.
- **API Gateway**: Centralized routing with Spring Cloud Gateway.
- **Database**: MySQL for persistent storage with JPA/Hibernate.
- **Resilience**: Circuit breaker and retry mechanisms with Resilience4j.
- **API Documentation**: Swagger UI for API exploration.
- **Testing**: Comprehensive API tests with Postman.

## 🏗️ Architecture
The system consists of the following microservices:
- **Eureka Server**: Service registry for discovery.
- **API Gateway**: Entry point for all client requests.
- **Book Service**: Manages book CRUD operations.
- **Order Service**: Handles order creation and management.
- **Inventory Service**: Tracks book stock levels.

### Architecture Diagram
![Architecture Diagram](https://raw.githubusercontent.com/lakshay1341/online-bookstore/main/docs/architecture-diagram.png)

*Diagram Explanation*: The client interacts with the API Gateway, which routes requests to the appropriate microservice. The Eureka Server enables service discovery, and each microservice communicates with the MySQL database for persistence.

### API Flow
The following diagram illustrates the API flow for placing an order:

Client → API Gateway (/orders) → Order Service → Inventory Service (update stock) → MySQL
← API Gateway ← Order Service ← Response (success/failure)


### Entity-Relationship (ER) Diagram
The database schema includes the following relationships:
- `books` ↔ `inventory`: One-to-One (each book has one inventory record).
- `orders` ↔ `books`: Many-to-Many (via `order_books` junction table).

![ER Diagram](https://raw.githubusercontent.com/lakshay1341/online-bookstore/main/docs/er-diagram.png)

*ER Diagram Details*:
- `books`: Stores book details (id, title, author, price, isbn, genre, stock_quantity).
- `orders`: Stores order details (id, order_date, customer_name, customer_email, total_amount).
- `order_books`: Junction table linking orders and books.
- `inventory`: Stores stock quantities (book_id, stock_quantity).

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
- Book Service: ![Book Service Swagger](https://raw.githubusercontent.com/lakshay1341/online-bookstore/main/docs/swagger-screenshots/books_swagger.png)
- Order Service: ![Order Service Swagger](https://raw.githubusercontent.com/lakshay1341/online-bookstore/main/docs/swagger-screenshots/orders_swagger.png)
- Inventory Service: ![Inventory Service Swagger](https://raw.githubusercontent.com/lakshay1341/online-bookstore/main/docs/swagger-screenshots/inventory_swagger.png)

## 📸 Screenshots
### Eureka Dashboard
![Eureka Dashboard](https://raw.githubusercontent.com/lakshay1341/online-bookstore/main/docs/screenshots/eureka_dashboard.png)

### Postman Tests
![Postman Test - GET /books](https://raw.githubusercontent.com/lakshay1341/online-bookstore/main/docs/api-testing/postman-screenshots/postman_get_books.png)

## 🧪 Running Tests
1. Import the Postman collection into Postman.
2. Set up the environment variables:
   - `baseUrl`: `http://localhost:8080`
   - `username`: `admin`
   - `password`: `password`
3. Run the collection to test all API endpoints.

## 🌐 Hosted Documentation
A static version of the API documentation is hosted on GitHub Pages: [Online Bookstore API Docs](https://lakshay1341.github.io/online-bookstore/)

## 📜 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📧 Contact
For questions or feedback, reach out to me at [lakshay1341@example.com](mailto:lakshaychaudhary2003@gmail.com).
  
