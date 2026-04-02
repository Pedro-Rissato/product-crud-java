package br.com.rissato.controller;

import br.com.rissato.model.Product;
import br.com.rissato.service.ProductService;


import java.math.BigDecimal;
import java.util.List;

public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    public void createProduct(Product product) throws Exception {
        this.productService.createProduct(product);
    }
    public Product getProductById(Long id) throws Exception {
        return this.productService.getProductById(id);
    }
    public List<Product> getAllProducts() throws Exception {
        return this.productService.getAllProducts();
    }
    public void updateProduct(Product product) throws Exception {
        this.productService.updateProduct(product);
    }
    public void deleteById(Long id) throws Exception {
        this.productService.deleteById(id);
    }
    public void updateStock(Long id, Integer quantity) throws Exception {
        this.productService.updateStock(id, quantity);
    }
    public void updateProductPrice(Long id, BigDecimal price) throws Exception {this.productService.adjustPrice(id,price);}
    public BigDecimal getProductFinalPrice(Long id) throws Exception {return this.productService.getFinalPrice(id);}
    public void updateDiscount(Long id, BigDecimal discount) throws Exception {this.productService.updateDiscount(id,discount);}
    public void updateDescription(Long id, String description) throws Exception {this.productService.adjustDescription(id,description);}
    public void updateName(Long id, String name) throws Exception {this.productService.adjustName(id,name);}
}
