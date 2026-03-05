package br.com.rissato.controller;

import br.com.rissato.model.Product;
import br.com.rissato.service.ProductService;

import java.util.List;

public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    public void createProduct(Product product) {
        this.productService.createProduct(product);
    }
    public Product getProductById(Long id) {
        return this.productService.getProductById(id);
    }
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }
    public void updateProduct(Product product) {
        this.productService.updateProduct(product);
    }
    public void deleteById(Long id) {
        this.productService.deleteById(id);
    }
    public void updateStock(Long id, Integer quantity) {
        this.productService.updateStock(id, quantity);
    }
    public void updateProductPrice(Long id, Double price) {
        this.productService.update
    }
}
