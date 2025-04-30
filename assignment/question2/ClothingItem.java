package question2;

public class ClothingItem extends ShoppingItem {
    private String size;
    private boolean isSeasonal;

    public ClothingItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String size, boolean isSeasonal) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.size = size;
        this.isSeasonal = isSeasonal;
    }

    @Override
    public void updateStock(int quantity) {
        stockAvailable -= quantity;
    }

    @Override
    public void addToCart(Customer customer, ShoppingCart cart, int quantity) {
        if (stockAvailable >= quantity) {
            double discountedPrice = price;
            if (isSeasonal) {
                discountedPrice = price * 0.9; 
            }
            cart.addItem(new ClothingItem(itemId, itemName, itemDescription, discountedPrice, stockAvailable, size, isSeasonal), quantity);
            updateStock(quantity);
            System.out.println(quantity + " " + itemName + " added to cart with price: $" + discountedPrice);
        } else {
            System.out.println("Not enough stock available!");
        }
    }

    @Override
    public void generateInvoice(Customer customer, int quantity) {
        System.out.println("Invoice for Clothing Item:");
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Item: " + itemName);
        System.out.println("Size: " + size);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: RWF" + (price * quantity));
    }

    @Override
    public boolean validateItem() {
        return price > 0 && stockAvailable > 0 && (size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL"));
    }
}
