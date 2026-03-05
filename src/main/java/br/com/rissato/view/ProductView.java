package br.com.rissato.view;
import br.com.rissato.controller.ProductController;
import br.com.rissato.model.Product;
import java.math.BigDecimal;
import java.util.*;
public class ProductView {
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
    public void showProducts() {
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        do {
            System.out.println("Choose an option: ");
            System.out.println("1. Show all products");
            System.out.println("2. Show product by id");
            System.out.println("0. Exit");

            switch(option){
                case 1:
                    showAllProducts();
                    break;
                case 2:
                    showProductById();
                    break;


            }
        }while (option != 0);

    }
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
            System.out.println("6. Update product description");
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
                    Long id3 = sc.nextLong();
                    System.out.println("Enter the product new price: ");
                    BigDecimal newPrice = sc.nextBigDecimal();
                    productController.updateProductPrice(id3,newPrice);
                case 4:
                    System.out.println("Enter the product ID: ");
                    Long id4 = sc.nextLong();
                    System.out.println("Enter the product discount: ");
                    BigDecimal newDiscount = sc.nextBigDecimal();
                    productController.updateDiscount(id4,newDiscount);
                case 5:
                    System.out.println("Enter the product ID: ");
                    Long id5 = sc.nextLong();
                    System.out.println("Enter the product name: ");
                    String newName = sc.nextLine();
                    productController.updateName(id5,newName);
                case 6:
                    System.out.println("Enter the product ID: ");
                    Long id6 = sc.nextLong();
                    System.out.println("Enter the product description: ");
                    String newDescription = sc.nextLine();
                    productController.updateDiscription(id6,newDescription);
            }
        }while(option!=0);

    }
    //delete
    public void deleteProductById(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the product ID: ");
        Long id = sc.nextLong();
        productController.deleteById(id);
    }




    public void start (){
        Scanner sc = new Scanner(System.in);
        int option;

        do{
            System.out.println("Choose an option");
            System.out.println("1 - Create Product");
            System.out.println("2 - Show Products");
            System.out.println("3 - Update Product");
            System.out.println("4 - Delete Product");
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
                    updateProduct();
                    break;
                case 4:
                    deleteProductById();
            }

        }while(option!=0);
    }

}
