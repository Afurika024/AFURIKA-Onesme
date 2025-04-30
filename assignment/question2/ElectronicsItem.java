package question2;

public class ElectronicsItem extends ShoppingItem {
    private int warrantyPeriod; 

    public ElectronicsItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, int warrantyPeriod) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void updateStock(int quantity) {
        stockAvailable -= quantity;
    }

    @Override
    public void addToCart(Customer customer, ShoppingCart cart, int quantity) {
        if (stockAvailable >= quantity) {
            cart.addItem(this, quantity);
            updateStock(quantity);
            System.out.println(quantity + " " + itemName + " added to cart.");
        } else {
            System.out.println("Not enough stock available!");
        }
    }

    @Override
    public void generateInvoice(Customer customer, int quantity) {
        System.out.println("Invoice for Electronics Item:");
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: RWF" + (price * quantity));
        System.out.println("Warranty: " + warrantyPeriod + " months");
    }

    @Override
    public boolean validateItem() {
        return price > 0 && stockAvailable > 0;
    }
}
