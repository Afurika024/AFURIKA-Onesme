package question1;

class Product {
    private String productId;
    private String productName;
    private String brand;
    private String supplier;
    private int stockQuantity;

    public Product(String productId, String productName, String brand, String supplier, int stockQuantity) {
        if (productName == null || productName.isEmpty()) throw new IllegalArgumentException("Product name cannot be empty.");
        if (stockQuantity < 0) throw new IllegalArgumentException("Stock quantity cannot be negative.");
        this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.supplier = supplier;
        this.stockQuantity = stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) throw new IllegalArgumentException("Stock quantity cannot be negative.");
        this.stockQuantity = stockQuantity;
    }

    public String getProductName() { return productName; }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}