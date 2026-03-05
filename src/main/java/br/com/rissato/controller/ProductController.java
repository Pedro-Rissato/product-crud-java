package br.com.rissato.controller;

import br.com.rissato.model.Product;
import br.com.rissato.service.ProductService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    public void createProduct(Product product) throws IOException {
        this.productService.createProduct(product);
    }
    public Product getProductById(Long id) {
        return this.productService.getProductById(id);
    }
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }
    public void updateProduct(Product product) throws IOException {
        this.productService.updateProduct(product);
    }
    public void deleteById(Long id) throws IOException {
        this.productService.deleteById(id);
    }
    public void updateStock(Long id, Integer quantity) throws IOException {
        this.productService.updateStock(id, quantity);
    }
    public void updateProductPrice(Long id, BigDecimal price) throws IOException {this.productService.adjustPrice(id,price);}
    public BigDecimal getProductFinalPrice(Long id) {return this.productService.getFinalPrice(id);}
    public void updateDiscount(Long id, BigDecimal discount) throws IOException {this.productService.updateDiscount(id,discount);}
    public void updateDescription(Long id, String description) throws IOException {this.productService.adjustDescription(id,description);}
    public void updateName(Long id, String name) throws IOException {this.productService.adjustName(id,name);}
}
