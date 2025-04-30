package question2;

public class BooksItem extends ShoppingItem {
    private String ISBN;
    private String edition;

    public BooksItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String ISBN, String edition) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.ISBN = ISBN;
        this.edition = edition;
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
        System.out.println("Invoice for Book Item:");
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Item: " + itemName);
        System.out.println("Edition: " + edition);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: RWF" + (price * quantity));
    }

    @Override
    public boolean validateItem() {
        return price > 0 && stockAvailable > 0 && ISBN.length() == 13;
    }
}
