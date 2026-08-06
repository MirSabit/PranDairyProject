package Inventory;


public class Inventory {

    private String stockId;
    private String productName;
    private int currentStock;
    private int minThreshold;
    private String location;
    private String availability;

    public Inventory(String stockId, String productName, int currentStock, int minThreshold,
                      String location, String availability) {
        this.stockId = stockId;
        this.productName = productName;
        this.currentStock = currentStock;
        this.minThreshold = minThreshold;
        this.location = location;
        this.availability = availability;
    }

    public String getStockId() {
        return stockId;
    }

    public String getProductName() {
        return productName;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public int getMinThreshold() {
        return minThreshold;
    }

    public String getLocation() {
        return location;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public boolean isLowStock() {
        return currentStock < minThreshold;
    }
}
