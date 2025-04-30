package question2;

public class AccessoriesItem extends ShoppingItem {
    private String variety;
    private double rating; 

    public AccessoriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String variety, double rating) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.variety = variety;
        this.rating = rating;
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
        System.out.println("Invoice for Accessories Item:");
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Item: " + itemName);
        System.out.println("Variety: " + variety);
        System.out.println("Rating: " + rating);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: RWF" + (price * quantity));
    }

    @Override
    public boolean validateItem() {
        return price > 0 && stockAvailable > 0 && rating >= 0.0 && rating <= 5.0;
    }
}
