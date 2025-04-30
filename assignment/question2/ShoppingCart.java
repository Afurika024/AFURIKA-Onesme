package question2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private String cartId;

    public String getCartId() {
        return cartId;
    }
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }
    private List<ShoppingItem> cartItems;
    private List<Integer> itemQuantities;
    private double totalPrice;

    public ShoppingCart(String cartId, Customer customer) {
        this.cartId = cartId;
        this.customer = customer;
        this.cartItems = new ArrayList<>();
        this.itemQuantities = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void addItem(ShoppingItem item, int quantity) {
        cartItems.add(item);
        itemQuantities.add(quantity);
        totalPrice += item.getPrice() * quantity;
    }

    public void displayCart() {
        System.out.println("\n--- Shopping Cart ---");
        for (int i = 0; i < cartItems.size(); i++) {
            ShoppingItem item = cartItems.get(i);
            int quantity = itemQuantities.get(i);
            System.out.println((i + 1) + ". " + item.itemName + " x" + quantity + " @ RWF" + item.price + " each");
        }
        System.out.println("Total Price: RWF" + totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<ShoppingItem> getCartItems() {
        return cartItems;
    }

    public List<Integer> getItemQuantities() {
        return itemQuantities;
    }
}
