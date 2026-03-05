package br.com.rissato.view;

import br.com.rissato.controller.ProductController;
import br.com.rissato.model.Product;

import java.math.BigDecimal;
import java.util.*;
;public class ProductView {
    private ProductController productController;
    public ProductView(ProductController productController) {
        this.productController = productController;

    }
    //create
    public void createProduct(){
        Scanner sc = new Scanner(System.in);

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

        productController.createProduct(product);
    }
    //showall
    public List<Product> showAllProducts(){
        return productController.getAllProducts();
    }
    //showbyid
    public Product showProductById(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the product ID: ");
        Long id = sc.nextLong();
        return productController.getProductById(id);
    }
    //update
    public void updateProduct(){
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            System.out.println("Choose an option: ");
            System.out.println("1. Update product");
            System.out.println("2. Update stock");
            System.out.println("3. Update product price");
            System.out.println("4. Update product discount");
            System.out.println("5. Update product name");
            System.out.println("0. Exit");
            option = sc.nextInt();
            switch (option){
                case 1:
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
                case 2:
                    System.out.println("Enter the product ID: ");
                    Long id2 = sc.nextLong();
                    System.out.println("Enter the amount: ");
                    Integer amount = sc.nextInt();
                    productController.updateStock(id2,amount);

                case 3:
                    System.out.println("Enter the product ID: ");
            }
        }while(option!=0);

    }
    //delete
    public void deleteProductById(Long id){
        productController.deleteById(id);
    }




    public void start (){
        Scanner sc = new Scanner(System.in);
        int option;

        do{
            System.out.println("Choose an option");
            System.out.println("1 - Create Product");
            System.out.println("2 - Show All Products");
            System.out.println("3 - Show Product by Id ");
            System.out.println("4 - Update Product");
            System.out.println("5 - Delete Product");
            System.out.println("0. Exit");
            option = sc.nextInt();
            switch (option){
                case 1:
                    createProduct();
                    break;
                case 2:
                    showAllProducts();
                    break;
                case 3:
                    showProductById();


            }

        }while(option!=0);
    }

}
