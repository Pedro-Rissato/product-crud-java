package br.com.rissato.model;

import java.math.BigDecimal;

public class Product {

    private String name;
    private Long id;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private BigDecimal discountPercentage = BigDecimal.ZERO;

    // Construtores
    public Product(String name, Long id, BigDecimal price, Integer stock, String description) {
        this.name = name;
        this.id = id;
        setPrice(price);
        setStock(stock);
        this.description = description;
    }
    public Product(String name, Long id, BigDecimal price, Integer stock) {
        this(name, id, price, stock, null);
    }

    public Product(Long id, String name, BigDecimal price, Integer stock, String description, BigDecimal discountPercentage) {
        this.id = id;
        this.name = name;
        setPrice(price);
        setStock(stock);
        this.description = description;
        this.discountPercentage = discountPercentage;
    }

    //Getters
    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public Integer getStock() {
        return stock;
    }
    public String getDescription() {
        return description;
    }
    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    // Setters
    public void setPrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
        throw new IllegalArgumentException("The price must be greater than zero.");
    }
        this.price = price; }
    public void setName(String name){this.name =name;}
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStock(Integer quantity) {
        if(quantity != null && quantity < 0){
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.stock = quantity;
    }
    public void setId(Long id){this.id = id;}


    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return java.util.Objects.equals(id, product.id);

    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }

    public String toFileString(){
        return id + " | " + name + " | " + price + " | " + stock + " | " + description + " | " + discountPercentage;
    }
    @Override
    public String toString(){
        return "ID: " + id + " | Name: " + name + " | Price: " + price + " | Stock: " + stock + " | Description: " + description + " | Discount Percentage: " + discountPercentage + "%";
    }


}
