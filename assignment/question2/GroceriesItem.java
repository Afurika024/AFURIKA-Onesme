package question2;

import java.time.LocalDate;

public class GroceriesItem extends ShoppingItem {
    private LocalDate expirationDate;

    public GroceriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, LocalDate expirationDate) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.expirationDate = expirationDate;
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
        System.out.println("Invoice for Groceries Item:");
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Expiration Date: " + expirationDate);
        System.out.println("Total Price: RWF" + (price * quantity));
    }

    @Override
    public boolean validateItem() {
        return expirationDate.isAfter(LocalDate.now()) && price > 0 && stockAvailable > 0;
    }
}
