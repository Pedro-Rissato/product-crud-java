# Product CRUD - Java

Simple product management domain model developed in Java to practice object-oriented design and business rule validation.

## 📌 Overview

This project implements a `Product` entity with:

- Financial precision using `BigDecimal`
- Optional stock control
- Discount percentage handling (0–99%)
- Final price calculation with financial rounding
- Encapsulated business rules
- Proper `equals()` and `hashCode()` implementation

## ⚙️ Technologies

- Java 21 (LTS)
- Maven
- BigDecimal for monetary calculations

## 🧠 Business Rules

- Price must be greater than zero.
- Stock cannot be negative.
- Discount must be between 0% and 99%.
- If stock is `null`, stock control is disabled.
- Final price uses `RoundingMode.HALF_UP`.

## 📁 Structure

src/main/java/br/com/rissato/model/Product.java

## 🚀 Future Improvements

- Add unit tests (JUnit)
- Implement Service layer
- Create REST API using Spring Boot
- Add persistence with JPA
