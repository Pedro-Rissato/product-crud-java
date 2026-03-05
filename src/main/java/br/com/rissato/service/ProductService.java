package br.com.rissato.service;

import br.com.rissato.model.Product;
import br.com.rissato.repository.ProductRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    public void createProduct(Product product) {
        if (product.getId() == null) {
            throw new IllegalArgumentException("ID inválido");
        }
        this.repository.save(product);
    }
    public List<Product> getAllProducts() {
        List<Product> products = this.repository.findAll();
        return products;
    }
    public Product getProductById(Long id) {
        return repository.findById(id);
    }
    public void updateProduct(Product product) {
        this.repository.updateProduct(product);
    }
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
    public void updateStock(Long id, Integer quantity){
        Product exists = repository.findById(id);
        if(exists!=null){
            exists.setStock(quantity);
            if(exists.getStock()+ quantity<0){
                throw new IllegalArgumentException("The stock cannot be negative.");
            }
            exists.setStock(exists.getStock()+ quantity);
        }
    }

    public void updateDiscount(Long id, BigDecimal discount) {
        Product exists = repository.findById(id);
        if(exists!=null){
            if (discount == null ||
                    discount.compareTo(BigDecimal.ZERO) < 0 ||
                    discount.compareTo(BigDecimal.valueOf(100)) >= 0 ||
            discount.compareTo(BigDecimal.valueOf(100)) > 0) {
                throw new IllegalArgumentException("The discount percentage needs to be between 0.0 and 100.");
            }
            exists.setDiscountPercentage(discount);
        }
    }
    public BigDecimal getFinalPrice(Long id) {
        Product exists = repository.findById(id);
        if(exists!=null){
            BigDecimal discountPercentage = exists.getDiscountPercentage();
            BigDecimal price = exists.getPrice();
            BigDecimal discount = price
                    .multiply(discountPercentage)
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

            return price.subtract(discount)
                    .setScale(2, RoundingMode.HALF_UP);
        }
        return exists.getPrice();


    }
    public void adjustPrice(Long id, BigDecimal price) {
        if(price.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("The price cannot be less than 0.");
        }
        Product exists = repository.findById(id);
        if(exists!=null){
            exists.setPrice(price);

        }
    }
    public void adjustDescription(Long id, String description) {
        Product exists = repository.findById(id);
        if(exists!=null){
            exists.setDescription(description);
        }
    }
    public void adjustName(Long id, String name){
        Product exists = repository.findById(id);
        if(exists!=null){
            exists.setName(name);
        }
    }

}
