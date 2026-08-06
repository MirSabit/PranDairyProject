package BatchRegistration;

public class BatchRegistration {

    private final String batchId;
    private final String productType;
    private final String estimatedQuantity;
    private final String sourceLocation;

    public BatchRegistration(String batchId, String productType, String estimatedQuantity, String sourceLocation) {
        this.batchId = batchId;
        this.productType = productType;
        this.estimatedQuantity = estimatedQuantity;
        this.sourceLocation = sourceLocation;
    }

    public String getBatchId() {
        return batchId;
    }

    public String getProductType() {
        return productType;
    }

    public String getEstimatedQuantity() {
        return estimatedQuantity;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }
}
