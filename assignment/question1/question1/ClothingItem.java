package question1;

import java.util.List;

class ClothingItem extends StockItem {
    private List<String> sizes;
    private List<String> colors;

    public ClothingItem(String itemId, String itemName, int quantity, double price, String category, String supplier, List<String> sizes, List<String> colors) {
        super(itemId, itemName, quantity, price, category, supplier);
        this.sizes = sizes;
        this.colors = colors;
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
        System.out.println("Clothing Item Report:");
        System.out.println("Item ID: " + itemId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Available Sizes: " + String.join(", ", sizes));
        System.out.println("Available Colors: " + String.join(", ", colors));
        System.out.println("Quantity: " + quantityInStock);
        System.out.printf("Stock Value: $%.2f%n", calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return quantityInStock > 0 && !sizes.isEmpty() && !colors.isEmpty();
    }
}