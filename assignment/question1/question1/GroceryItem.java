package question1;

import java.time.LocalDate;

class GroceryItem extends StockItem {
    private LocalDate expirationDate;

    public GroceryItem(String itemId, String itemName, int quantity, double price, String category, String supplier, LocalDate expirationDate) {
        super(itemId, itemName, quantity, price, category, supplier);
        this.expirationDate = expirationDate;
    }

    @Override
    public void updateStock(int quantity) {
        if (quantityInStock + quantity >= 0) {
            quantityInStock += quantity;
        } else {
            System.out.println("Error: Stock cannot be negative.");
        }
    }

    @Override
    public double calculateStockValue() {
        return quantityInStock * pricePerUnit;
    }

    @Override
    public void generateStockReport() {
        System.out.println("Grocery Item Report:");
        System.out.println("Item ID: " + itemId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Expiration Date: " + expirationDate);
        System.out.println("Quantity: " + quantityInStock);
        System.out.printf("Stock Value: $%.2f%n", calculateStockValue());
        if (expirationDate.isBefore(LocalDate.now().plusDays(30))) {
            System.out.println("Alert: Item nearing expiration. Consider discount.");
        }
    }

    @Override
    public boolean validateStock() {
        return expirationDate.isAfter(LocalDate.now()) && quantityInStock > 0;
    }
}
