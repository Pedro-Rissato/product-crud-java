package br.com.rissato.view;
import br.com.rissato.controller.ProductController;
import br.com.rissato.model.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
public class ProductView {
    private final ProductController productController;
    public ProductView(ProductController productController) {
        this.productController = productController;
    }
    private final Scanner sc = new Scanner(System.in);
    //create
    public void createProduct() throws IOException {
        System.out.println("Enter the product name: ");
        String name = sc.nextLine();
        System.out.println("Enter the product price: ");
        BigDecimal price = sc.nextBigDecimal();
        System.out.println("Enter the product quantity: ");
        Integer quantity = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the product description: ");
        String description = sc.nextLine();
        Product product = new Product(name, null ,price,quantity,description);
        productController.createProduct(product);

        System.out.println("Product created successfully! " + product);
    }
    //showAll
    public void showProducts() {
        int option;

        do {
            separator();
            System.out.println("Choose an option: ");
            System.out.println("1. Show all products");
            System.out.println("2. Show product by id");
            System.out.println("3. Show product final price by id");
            System.out.println("0. Exit");

            option = sc.nextInt();
            switch(option){
                case 1:
                    separator();
                    showAllProducts();
                    break;
                case 2:
                    separator();
                    showProductById();
                    break;
                case 3:
                    separator();
                    showProductFinalPrice();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }while (option != 0);

    }
    public void showAllProducts(){
        List<Product> products = productController.getAllProducts();

        if(products.isEmpty()){
            System.out.println("No products found.");
            return;
        }

        for(Product p : products){
            System.out.println(p);
        }
    }
    //showById
    public void showProductById(){
        System.out.println("Enter the product ID: ");
        Long id = sc.nextLong();
        Product product = productController.getProductById(id);
        System.out.println(product);
    }
    public void showProductFinalPrice(){
        System.out.println("Enter the product ID: ");
        Long id = sc.nextLong();
        BigDecimal price = productController.getProductFinalPrice(id);
        System.out.println("Final price: " + price);
    }
    //update
    public void updateProduct() throws IOException {
        int option;
        do{
            separator();
            System.out.println("Choose an option: ");
            System.out.println("1. Update product");
            System.out.println("2. Update stock");
            System.out.println("3. Update product price");
            System.out.println("4. Update product discount");
            System.out.println("5. Update product name");
            System.out.println("6. Update product description");
            System.out.println("0. Exit");
            option = sc.nextInt();
            switch (option){
                case 1:
                    separator();
                    System.out.println("Enter the product ID: ");
                    Long id = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Enter the product name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter the product price: ");
                    BigDecimal price = sc.nextBigDecimal();
                    System.out.println("Enter the product quantity: ");
                    Integer quantity = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the product description: ");
                    String description = sc.nextLine();
                    Product product = new Product(name, id ,price,quantity,description);
                    productController.updateProduct(product);
                    System.out.println("Product updated successfully! " + productController.getProductById(id));
                    break;
                case 2:
                    separator();
                    System.out.println("Enter the product ID: ");
                    Long id2 = sc.nextLong();
                    System.out.println("Enter the amount: ");
                    Integer amount = sc.nextInt();
                    productController.updateStock(id2,amount);
                    System.out.println("Product updated successfully! " + productController.getProductById(id2));
                    break;
                case 3:
                    separator();
                    System.out.println("Enter the product ID: ");
                    Long id3 = sc.nextLong();
                    System.out.println("Enter the product new price: ");
                    BigDecimal newPrice = sc.nextBigDecimal();
                    productController.updateProductPrice(id3,newPrice);
                    System.out.println("Product updated successfully! " + productController.getProductById(id3));
                    break;
                case 4:
                    separator();
                    System.out.println("Enter the product ID: ");
                    Long id4 = sc.nextLong();
                    System.out.println("Enter the product discount: ");
                    BigDecimal newDiscount = sc.nextBigDecimal();
                    productController.updateDiscount(id4,newDiscount);
                    System.out.println("Product updated successfully! " + productController.getProductById(id4));
                    break;
                case 5:
                    separator();
                    System.out.println("Enter the product ID: ");
                    Long id5 = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Enter the product name: ");
                    String newName = sc.nextLine();
                    productController.updateName(id5,newName);
                    System.out.println("Product updated successfully! " + productController.getProductById(id5));
                    break;
                case 6:
                    separator();
                    System.out.println("Enter the product ID: ");
                    Long id6 = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Enter the product description: ");
                    String newDescription = sc.nextLine();
                    productController.updateDescription(id6,newDescription);
                    System.out.println("Product updated successfully! " + productController.getProductById(id6));
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }while(option!=0);

    }
    //delete
    public void deleteProductById() throws IOException {
        System.out.println("Enter the product ID: ");
        Long id = sc.nextLong();
        productController.deleteById(id);
        System.out.println("Product deleted successfully!");
    }
    public void start () throws IOException {
        int option;

        do{
            separator();
            System.out.println("Choose an option");
            System.out.println("1 - Create Product");
            System.out.println("2 - Show Products");
            System.out.println("3 - Update Product");
            System.out.println("4 - Delete Product");
            System.out.println("0. Exit");
            option = sc.nextInt();
            switch (option){
                case 1:
                    separator();
                    createProduct();
                    break;
                case 2:
                    separator();
                    showProducts();
                    break;
                case 3:
                    separator();
                    updateProduct();
                    break;
                case 4:
                    separator();
                    deleteProductById();
                    break;
                default:
                    separator();
                    System.out.println("Invalid option.");
            }

        }while(option!=0);
    }
    public void separator(){
        System.out.println("--------------------------------");
    }
}
