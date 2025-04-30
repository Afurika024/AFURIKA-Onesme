package question1;

class ElectronicsItem extends StockItem {
    private int warrantyPeriod;

    public ElectronicsItem(String itemId, String itemName, int quantity, double price, String category, String supplier, int warranty) {
        super(itemId, itemName, quantity, price, category, supplier);
        if (warranty < 0) throw new IllegalArgumentException("Warranty cannot be negative.");
        this.warrantyPeriod = warranty;
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
        System.out.println("Electronics Item Report:");
        System.out.println("Item ID: " + itemId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Quantity: " + quantityInStock);
        System.out.printf("Stock Value: $%.2f%n", calculateStockValue());
        System.out.println("Warranty Period: " + warrantyPeriod + " months");
    }

    @Override
    public boolean validateStock() {
        return quantityInStock > 0;
    }

    public void applyDiscount(double discountPercentage) {
        if (discountPercentage <= 50) {
            pricePerUnit *= (1 - discountPercentage / 100);
        } else {
            System.out.println("Discount cannot exceed 50%.");
        }
    }
}