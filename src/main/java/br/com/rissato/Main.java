package br.com.rissato;

import br.com.rissato.controller.ProductController;
import br.com.rissato.repository.ProductRepository;
import br.com.rissato.service.ProductService;
import br.com.rissato.view.ProductView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductService(productRepository);
        ProductController productController = new ProductController(productService);
        ProductView productView = new ProductView(productController);

        productView.start();
    }
}
