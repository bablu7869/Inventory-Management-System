import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class InventoryManagementSystem {
    private Map<String, Product> productMap = new HashMap<>();

    public void addProduct(String name, double price, int quantity) {
        Product product = new Product(name, price, quantity);
        productMap.put(name, product);
        System.out.println("Product added successfully.");
    }

    public void updateProduct(String name, double price, int quantity) {
        if (productMap.containsKey(name)) {
            Product product = productMap.get(name);
            product.price = price;
            product.quantity = quantity;
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void removeProduct(String name) {
        if (productMap.containsKey(name)) {
            productMap.remove(name);
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayProducts() {
        for (Product product : productMap.values()) {
            System.out.println(product.name + " - Price: $" + product.price + " - Quantity: " + product.quantity);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Product\n2. Update Product\n3. Remove Product\n4. Display Products\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    ims.addProduct(name, price, quantity);
                    break;
                case 2:
                    System.out.print("Enter product name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double updatePrice = scanner.nextDouble();
                    System.out.print("Enter new quantity: ");
                    int updateQuantity = scanner.nextInt();
                    ims.updateProduct(updateName, updatePrice, updateQuantity);
                    break;
                case 3:
                    System.out.print("Enter product name to remove: ");
                    String removeName = scanner.nextLine();
                    ims.removeProduct(removeName);
                    break;
                case 4:
                    ims.displayProducts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
