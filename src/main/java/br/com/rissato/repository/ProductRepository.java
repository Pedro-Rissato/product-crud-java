package br.com.rissato.repository;

import br.com.rissato.model.Product;

import java.math.BigDecimal;
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
           }

       }
       public void updateStock(Long id, Integer quantity){
            Product exists = findById(id);

            if(exists!=null){
                exists.setStock(exists.getStock()+ quantity);
            }
       }

    public void setDiscountPercentage(Long id, BigDecimal discountPercentage) {
        Product exists = findById(id);
        if(exists!=null){
            if (discountPercentage == null ||
                    discountPercentage.compareTo(BigDecimal.ZERO) < 0 ||
                    discountPercentage.compareTo(BigDecimal.valueOf(100)) >= 0) {
                throw new IllegalArgumentException("The discount percentage must be between 0 and 100.");
            }

        }
        exists.setDiscountPercentage(discountPercentage);
    }
    public void adjustPrice(Long id, BigDecimal price) {
        Product exists = findById(id);
        if(exists!=null){
            exists.setPrice(price);
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("The price must be greater than zero.");
        }
        t
    }
}
