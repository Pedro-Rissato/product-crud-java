package br.com.rissato.service;

import br.com.rissato.model.Product;
import br.com.rissato.repository.ProductRepository;

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
}
