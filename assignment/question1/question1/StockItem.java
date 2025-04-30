
package question1;

abstract class StockItem {
    protected String itemId;
    protected String itemName;
    protected int quantityInStock;
    protected double pricePerUnit;
    protected String category;
    protected String supplier;

    public StockItem(String itemId, String itemName, int quantity, double price, String category, String supplier) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantityInStock = quantity;
        this.pricePerUnit = price;
        this.category = category;
        this.supplier = supplier;
    }

    public abstract void updateStock(int quantity);
    public abstract double calculateStockValue();
    public abstract void generateStockReport();
    public abstract boolean validateStock();

    // ✨ Add basic setters to allow updating fields
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setQuantityInStock(int quantity) { this.quantityInStock = quantity; }
    public void setPricePerUnit(double price) { this.pricePerUnit = price; }
    public void setSupplier(String supplier) { this.supplier = supplier; }

    public String getItemId() { return itemId; }
    public String getItemName() { return itemName; }
}