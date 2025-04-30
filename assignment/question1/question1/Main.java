package question1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<StockItem> stockItems = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Add Stock Item\n2. Update Stock Item\n3. Generate Report\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addStockItem(); break;
                case 2: updateStockItem(); break;
                case 3: generateReport(); break;
                case 4: exit = true; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void addStockItem() {
        System.out.println("Enter item type (1-5):\n1. Electronics\n2. Clothing\n3. Grocery\n4. Furniture\n5. Perishable");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Item ID: ");
        String id = scanner.nextLine();
        System.out.print("Item Name: ");
        String name = scanner.nextLine();
        System.out.print("Quantity: ");
        int qty = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Supplier: ");
        String supplier = scanner.nextLine();

        switch (type) {
            case 1:
                System.out.print("Warranty (months): ");
                int warranty = scanner.nextInt();
                scanner.nextLine();
                stockItems.add(new ElectronicsItem(id, name, qty, price, category, supplier, warranty));
                break;
            case 2:
                System.out.print("Sizes (comma-separated): ");
                List<String> sizes = Arrays.asList(scanner.nextLine().split(","));
                System.out.print("Colors (comma-separated): ");
                List<String> colors = Arrays.asList(scanner.nextLine().split(","));
                stockItems.add(new ClothingItem(id, name, qty, price, category, supplier, sizes, colors));
                break;
            case 3:
                System.out.print("Expiration (yyyy-mm-dd): ");
                LocalDate exp = LocalDate.parse(scanner.nextLine());
                stockItems.add(new GroceryItem(id, name, qty, price, category, supplier, exp));
                break;
            case 4:
                System.out.print("Weight (kg): ");
                double weight = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Is packed (true/false): ");
                boolean packed = scanner.nextBoolean();
                scanner.nextLine();
                stockItems.add(new FurnitureItem(id, name, qty, price, category, supplier, weight, packed));
                break;
            case 5:
                System.out.print("Expiration (yyyy-mm-dd): ");
                LocalDate perishExp = LocalDate.parse(scanner.nextLine());
                stockItems.add(new PerishableItem(id, name, qty, price, category, supplier, perishExp));
                break;
            default: System.out.println("Invalid type.");
        }
    }

    private static void updateStockItem() {
        System.out.print("Enter Item ID to update: ");
        String id = scanner.nextLine();
        boolean found = false;

        for (StockItem item : stockItems) {
            if (item.getItemId().equalsIgnoreCase(id)) {
                found = true;
                System.out.println("What do you want to update?\n1. Name\n2. Quantity\n3. Price\n4. Supplier");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("New name: ");
                        item.setItemName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("New quantity: ");
                        item.setQuantityInStock(scanner.nextInt());
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.print("New price: ");
                        item.setPricePerUnit(scanner.nextDouble());
                        scanner.nextLine();
                        break;
                    case 4:
                        System.out.print("New supplier: ");
                        item.setSupplier(scanner.nextLine());
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
                System.out.println("Item updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }

    private static void generateReport() {
        System.out.println("\n--- Inventory Report ---");
        for (StockItem item : stockItems) {
            item.generateStockReport();
            System.out.println("-----------------------------");
        }
    }
}