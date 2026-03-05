package br.com.rissato.repository;

import br.com.rissato.model.Product;
import java.util.*;

public class ProductRepository {
    private List<Product> productList = new ArrayList<>();

        //CREATE
        public void save(Product product){
            productList.add(product);
        }
        //READ
        public List<Product> findAll(){
            return productList;
        }
        public Product findById(Long id){
            return  productList.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
        }
        //DELETE
        public void deleteById(Long id){
            productList.removeIf(product -> product.getId().equals(id));
        }
        //UPDATE
       public void updateProduct(Product updatedProduct){
           Product exists = findById((updatedProduct.getId()));

           if(exists!=null){
               exists.setName(updatedProduct.getName());
               exists.setPrice(updatedProduct.getPrice());
               exists.setDescription(updatedProduct.getDescription());
               exists.setStock(updatedProduct.getStock());
           }

       }
}
