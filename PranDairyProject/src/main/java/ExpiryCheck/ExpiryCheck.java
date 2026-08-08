package ExpiryCheck;

public class ExpiryCheck {

    private final String productName;
    private final String batchId;
    private final String daysRemaining;
    private final String result;

    public ExpiryCheck(String productName, String batchId, String daysRemaining, String result) {
        this.productName = productName;
        this.batchId = batchId;
        this.daysRemaining = daysRemaining;
        this.result = result;
    }

    public String getProductName() {
        return productName;
    }

    public String getBatchId() {
        return batchId;
    }

    public String getDaysRemaining() {
        return daysRemaining;
    }

    public String getResult() {
        return result;
    }
}
