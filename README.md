# Product Management System (Java)

---

##  Java • OOP • CRUD • MVC • File Persistence

---

A simple **product management system** built in Java using a layered architecture.
The application allows users to create, update, delete and manage products through a **console interface**, while persisting data in a local file.

This project was developed to practice **object-oriented programming, layered architecture, and business logic separation**.



# Features

* Create new products
* List all products
* Find product by ID
* Update product information
* Update product stock
* Update product price
* Apply product discounts
* Calculate final price with discount
* Delete products
* Data persistence using a local text file

---

# Project Architecture

The project follows a **layered architecture inspired by MVC**.

```
View → Controller → Service → Repository → Model
```

### Model

Represents the domain object.

```
Product
```

Contains:

* product attributes
* validations
* business data

---

### Repository

Responsible for **data persistence**.

```
ProductRepository
```

Responsibilities:

* Store products in memory using a `HashMap`
* Persist data to a file (`Products.txt`)
* Load saved data on application startup

---

### Service

Contains the **business rules of the application**.

```
ProductService
```

Responsibilities:

* Validate operations
* Control stock updates
* Handle discount logic
* Calculate final price
* Ensure product existence

---

### Controller

Acts as a **bridge between View and Service**.

```
ProductController
```

Responsibilities:

* Receive requests from the view
* Call the appropriate service methods

---

### View

Handles **user interaction via console**.

```
ProductView
```

Responsibilities:

* Display menus
* Read user input
* Show results

---

# Project Structure

```
src
└── br/com/rissato
    ├── controller
    │   └── ProductController.java
    │
    ├── model
    │   └── Product.java
    │
    ├── repository
    │   └── ProductRepository.java
    │
    ├── service
    │   └── ProductService.java
    │
    └── view
        └── ProductView.java
```

---

# Technologies Used

* **Java**
* **OOP (Object-Oriented Programming)**
* **BigDecimal** for financial calculations
* **File persistence (java.nio.file)**
* **Collections (HashMap, List)**

---

# How to Run

1. Clone the repository

```
git clone https://github.com/your-username/product-management-system.git
```

2. Open the project in your IDE
   (IntelliJ IDEA recommended)

3. Run the main class that starts the application.

Example menu:

```
Choose an option
1 - Create Product
2 - Show Products
3 - Update Product
4 - Delete Product
0 - Exit
```

---

# Business Rules

* Product price must be greater than **0**
* Stock cannot be **negative**
* Discount must be between **0% and 100% (exclusive)**
* Product IDs are generated automatically

---

# Learning Goals

This project was created to practice:

* Java object-oriented programming
* Layered architecture
* Separation of concerns
* CRUD operations
* File persistence
* Console-based interfaces

---

# Future Improvements

Possible future enhancements:

* REST API using **Spring Boot**
* Database integration (**PostgreSQL / MySQL**)
* Input validation improvements
* Unit tests
* Web interface

---

# Author

Developed as a Java learning project.
