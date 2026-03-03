package br.com.rissato.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    final private String name;
    final private Long id;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private BigDecimal discountPercentage = BigDecimal.ZERO;

    // Construtores
    public Product(String name, Long id, BigDecimal price, Integer stock, String description) {
        if(price==null || price.compareTo(BigDecimal.ZERO)<=0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        if(stock != null && stock< 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.name = name;
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }
    public Product(String name, Long id, BigDecimal price, Integer stock) {
        this(name, id, price, stock, null);
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
    public void setDescription(String description) {
        this.description = description;
    }
    public void increaseStock(int quantity) {
        if (quantity <= 0 ) {
            throw new IllegalArgumentException("The quantity must be greater than zero.");
        }
        if (this.stock == null) {
            this.stock = 0;
        }
        this.stock += quantity;
    }

    public void decreaseStock(int quantity) {
        if(!hasStockControl()){
            throw new IllegalArgumentException("The stock control has not been set.");
        }
        if (quantity < 0 ) {
            throw new IllegalArgumentException("The stock cannot be negative.");
        }
        if (quantity > this.stock ) {
            throw new IllegalArgumentException("The quantity must be less than stock.");
        }
        this.stock -= quantity;
    }

    public void adjustPrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("The price must be greater than zero.");
        }
        this.price = price;
    }
    public void setDiscountPercentage(BigDecimal discountPercentage) {
        if (discountPercentage == null ||
                discountPercentage.compareTo(BigDecimal.ZERO) < 0 ||
                discountPercentage.compareTo(BigDecimal.valueOf(100)) >= 0) {
            throw new IllegalArgumentException("The discount percentage must be between 0 and 100.");
        }
        this.discountPercentage = discountPercentage;
    }
    public BigDecimal getFinalPrice() {
        BigDecimal discount = price
                .multiply(discountPercentage)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        return price.subtract(discount)
                .setScale(2, RoundingMode.HALF_UP);

    }
    //StockControl
    public boolean hasStockControl() {
        return stock != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id.equals(product.id);

    }
    @Override
    public int hashCode() {
        return id.hashCode(id);
    }
}
