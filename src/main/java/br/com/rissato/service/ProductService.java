package br.com.rissato.service;

import br.com.rissato.model.Product;
import br.com.rissato.repository.ProductRepository;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public void createProduct(Product product) throws Exception {
        if(product.getId() != null){
            throw new IllegalArgumentException("New product cannot have an id");
        }
        repository.save(product);
    }

    public List<Product> getAllProducts() throws Exception {
        return repository.findAll();
    }
    public Product getProductById(Long id) throws Exception {
        return getExistingProduct(id);
    }
    public void updateProduct(Product updatedProduct) throws Exception {
        if(updatedProduct.getId() == null){
            throw new NoSuchElementException("Product id cannot be null");
        }
        getExistingProduct((updatedProduct.getId()));
        repository.update(updatedProduct);


    }
    public void deleteById(Long id) throws Exception {
        getExistingProduct(id);
        repository.deleteById(id);

    }
    public void updateStock(Long id, Integer quantity) throws Exception {
        if (quantity == null || quantity == 0) {
            throw new IllegalArgumentException("Quantity cannot be null or zero");
        }
        Product exists = getExistingProduct(id);
        Integer newStock = exists.getStock() + quantity;
        if(newStock<0){
            throw new IllegalArgumentException("The stock cannot be negative.");
        }
            exists.setStock(newStock);
            repository.update(exists);

    }

    public void updateDiscount(Long id, BigDecimal discount) throws Exception {
        Product exists = getExistingProduct(id);
        if (discount == null ||
                discount.compareTo(BigDecimal.ZERO) < 0 ||
                discount.compareTo(BigDecimal.valueOf(100)) >= 0) {
            throw new IllegalArgumentException("The discount percentage needs to be between 0.0 and 100.");
        }
        exists.setDiscountPercentage(discount);
        repository.update(exists);

    }
    public BigDecimal getFinalPrice(Long id) throws Exception {
        Product exists = getExistingProduct(id);
        BigDecimal discountPercentage = exists.getDiscountPercentage();
        if(discountPercentage==null || discountPercentage.compareTo(BigDecimal.ZERO)<=0){
            return exists.getPrice();
        }
        BigDecimal price = exists.getPrice();
        BigDecimal discount = price
                .multiply(discountPercentage)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        return price.subtract(discount)
                .setScale(2, RoundingMode.HALF_UP);



    }
    public void adjustPrice(Long id, BigDecimal price) throws Exception {
        if(price == null || price.compareTo(BigDecimal.ZERO) <= 0 ){
            throw new IllegalArgumentException("The price cannot be null or less/equal to 0.");
        }
        Product exists = getExistingProduct(id);
        exists.setPrice(price);
        repository.update(exists);
    }
    public void adjustDescription(Long id, String description) throws Exception {
        if(description == null || description.isBlank()){
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        Product exists = getExistingProduct(id);
        exists.setDescription(description);
        repository.update(exists);
    }
    public void adjustName(Long id, String name) throws Exception {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("The name cannot be null or blank");
        }
        Product exists = getExistingProduct(id);
        exists.setName(name);
        repository.update(exists);
    }
    private Product getExistingProduct(Long id) throws Exception {
        List<Product> product = repository.findById(id);
        if(product == null){
            throw new NoSuchElementException("Product not found with id: " + id);
        }
        return (Product) product;
    }
}
