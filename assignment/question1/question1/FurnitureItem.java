package question1;

class FurnitureItem extends StockItem {
    private double weight;
    private boolean isPacked;

    public FurnitureItem(String itemId, String itemName, int quantity, double price, String category, String supplier, double weight, boolean isPacked) {
        super(itemId, itemName, quantity, price, category, supplier);
        this.weight = weight;
        this.isPacked = isPacked;
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
        System.out.println("Furniture Item Report:");
        System.out.println("Item ID: " + itemId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Packed: " + (isPacked ? "Yes" : "No"));
        System.out.println("Quantity: " + quantityInStock);
        System.out.printf("Stock Value: $%.2f%n", calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return isPacked && quantityInStock > 0;
    }
}