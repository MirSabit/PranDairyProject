package MinimumStock;

public class MinimumStock {

    private String productId;
    private String productName;
    private String minStockLevel;

    public MinimumStock(String productId, String productName, String minStockLevel) {
        this.productId = productId;
        this.productName = productName;
        this.minStockLevel = minStockLevel;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getMinStockLevel() {
        return minStockLevel;
    }
}
