package ProductQualityCheck;

public class ProductQualityCheck {

    private final String productBatchId;
    private final String productName;
    private final String sealIntegrity;
    private final String labelAccuracy;
    private final String result;

    public ProductQualityCheck(String productBatchId, String productName, String sealIntegrity, String labelAccuracy, String result) {
        this.productBatchId = productBatchId;
        this.productName = productName;
        this.sealIntegrity = sealIntegrity;
        this.labelAccuracy = labelAccuracy;
        this.result = result;
    }

    public String getProductBatchId() {
        return productBatchId;
    }

    public String getProductName() {
        return productName;
    }

    public String getSealIntegrity() {
        return sealIntegrity;
    }

    public String getLabelAccuracy() {
        return labelAccuracy;
    }

    public String getResult() {
        return result;
    }
}
