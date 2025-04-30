package question2;

public abstract class ShoppingItem {
    protected String itemId;
    protected String itemName;
    protected String itemDescription;
    protected double price;
    protected int stockAvailable;

    public ShoppingItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.price = price;
        this.stockAvailable = stockAvailable;
    }

    public abstract void updateStock(int quantity);

    public abstract void addToCart(Customer customer, ShoppingCart cart, int quantity);

    public abstract void generateInvoice(Customer customer, int quantity);

    public abstract boolean validateItem();

    public double getPrice() {
        return price;
    }
}
