package question1;

import java.util.ArrayList;
import java.util.List;

class Warehouse {
    private String warehouseId;
    private String location;
    private int capacity;
    private String managerName;
    private List<StockItem> inventory = new ArrayList<>();

    public Warehouse(String warehouseId, String location, int capacity, String managerName) {
        this.warehouseId = warehouseId;
        this.location = location;
        this.capacity = capacity;
        this.managerName = managerName;
    }

    public void addStockItem(StockItem item) {
        if (inventory.size() < capacity) {
            inventory.add(item);
        } else {
            System.out.println("Warehouse is full.");
        }
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public List<StockItem> getInventory() {
        return inventory;
    }

    public void setInventory(List<StockItem> inventory) {
        this.inventory = inventory;
    }
}