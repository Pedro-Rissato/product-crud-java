package br.com.rissato.repository;

import br.com.rissato.model.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ProductRepository {
    private Long nextId = 1L;
    private final Map<Long, Product> productMap = new HashMap<>();
    private final Path filePath = Path.of("Products.txt");

        public ProductRepository(){
            loadFromFile();
        }
        //CREATE
        public void save(Product product) throws IOException {
            if(product.getId() != null){
                throw new IllegalArgumentException("Product already has an id");
            }
            product.setId(nextId++);
            productMap.put(product.getId(), product);

            saveToFile();
        }
        //READ
        public List<Product> findAll(){
            return new ArrayList<>(productMap.values());
        }
        public Product findById(Long id){
            return  productMap.get(id);
        }
        //DELETE
        public void deleteById(Long id) throws IOException {
            if(!productMap.containsKey(id)){
                throw new IllegalArgumentException("Product not found");
            }
            productMap.remove(id);
            saveToFile();
        }

        public void saveToFile() throws IOException {
            List<String> lines = productMap.values()
                    .stream()
                    .map(Product::toFileString)
                    .toList();
            Files.write(filePath, lines);

        }
        public void loadFromFile() {
            if (!Files.exists(filePath)){
                return;
            }
            try{
                List<String> lines = Files.readAllLines(filePath);
                for (String line: lines){
                    String[] parts = line.split("\\|", -1);
                    if(parts.length != 6){
                        continue;
                    }
                    Long id = Long.parseLong(parts[0]);
                    String name = parts[1];
                    BigDecimal price = new BigDecimal(parts[2]);
                    Integer stock = Integer.parseInt(parts[3]);
                    String description = parts[4];
                    BigDecimal discountPercentage = new BigDecimal(parts[5]);

                    Product product = new Product(id, name, price, stock, description, discountPercentage);

                    productMap.put(id, product);
                    if(id>= nextId){
                        nextId = id+1;
                    }

                }
            } catch (IOException | NumberFormatException e) {
                throw new RuntimeException(e);
            }

        }
        public void update(Product product) throws IOException{
            if(product.getId() == null || !productMap.containsKey(product.getId())){
                throw new IllegalArgumentException("Product not found");
            }

            productMap.put(product.getId(), product);
            saveToFile();
    }



       }

