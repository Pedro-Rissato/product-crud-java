package br.com.rissato.controller;

import br.com.rissato.model.Product;
import br.com.rissato.service.ProductService;

import java.math.BigDecimal;
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
    public void updateProductPrice(Long id, BigDecimal price) {this.productService.adjustPrice(id,price);}
    public BigDecimal getProductFinalPrice(Long id) {return this.productService.getFinalPrice(id);}
    public void updateDiscount(Long id, BigDecimal discount) {this.productService.updateDiscount(id,discount);}
    public void updateDiscription(Long id, String description){this.productService.adjustDescription(id,description);}
    public void updateName(Long id, String name){this.productService.adjustName(id,name);}
}
