package SupplyInfo;

public class SupplyInfo {

    private final String recordId;
    private final String productType;
    private final String price;
    private final String contactNumber;

    public SupplyInfo(String recordId, String productType, String price, String contactNumber) {
        this.recordId = recordId;
        this.productType = productType;
        this.price = price;
        this.contactNumber = contactNumber;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getProductType() {
        return productType;
    }

    public String getPrice() {
        return price;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
