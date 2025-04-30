package question2;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("Enter Customer Details:");
        System.out.print("Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(customerId, name, email, address, phone);

        
        ShoppingCart cart = new ShoppingCart("CART001", customer);

       
        ElectronicsItem laptop = new ElectronicsItem("E001", "Laptop", "Gaming Laptop", 1200.0, 10, 24);
        ClothingItem tshirt = new ClothingItem("C001", "T-shirt", "Summer T-shirt", 25.0, 50, "M", true);
        GroceriesItem apple = new GroceriesItem("G001", "Apple", "Fresh Apple", 2.0, 100, LocalDate.now().plusDays(10));
        BooksItem book = new BooksItem("B001", "Java Programming", "Learn Java", 45.0, 20, "9781234567890", "1st");
        AccessoriesItem watch = new AccessoriesItem("A001", "Watch", "Smart Watch", 150.0, 30, "Smart", 4.5);

        ShoppingItem[] items = {laptop, tshirt, apple, book, watch};

        
        while (true) {
            System.out.println("\nAvailable Items:");
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i].itemName + " - RWF" + items[i].price + " (" + items[i].stockAvailable + " available)");
            }
            System.out.println("6. Checkout");

            System.out.print("Choose an item (1-6): ");
            int choice = scanner.nextInt();
            if (choice == 6) {
                break;
            }
            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice!");
                continue;
            }

            ShoppingItem selectedItem = items[choice - 1];
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            if (selectedItem.stockAvailable >= quantity && quantity > 0) {
                selectedItem.addToCart(customer, cart, quantity);
            } else {
                System.out.println("Invalid quantity! Not enough stock.");
            }
        }

        
        cart.displayCart();

        
        System.out.println("\nProceed to Payment:");
        System.out.print("Payment ID: ");
        scanner.nextLine();
        String paymentId = scanner.nextLine();
        System.out.print("Payment Method (CreditCard/PayPal): ");
        String method = scanner.nextLine();
        double amount = cart.getTotalPrice();

        Payment payment = new Payment(paymentId, method, amount);
        if (payment.validatePayment()) {
            System.out.println("Payment Successful on " + payment.getTransactionDate());
        } else {
            System.out.println("Payment Failed. Invalid method or amount.");
            scanner.close();
            return;
        }

       
        System.out.println("\n--- Final Invoice ---");
        for (int i = 0; i < cart.getCartItems().size(); i++) {
            ShoppingItem item = cart.getCartItems().get(i);
            int quantity = cart.getItemQuantities().get(i);
            item.generateInvoice(customer, quantity);
            System.out.println();
        }

        System.out.println("Total Paid: RWF" + amount);
        System.out.println("Order Placed Successfully!");
        scanner.close();
    }
}
