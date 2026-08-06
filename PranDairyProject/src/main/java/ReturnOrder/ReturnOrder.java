package ReturnOrder;

public class ReturnOrder {

    private String productId;
    private String productName;
    private String dateOfPurchase;
    private String causeForReturn;
    private String address;

    public ReturnOrder(String productId, String productName, String dateOfPurchase, String causeForReturn, String address) {
        this.productId = productId;
        this.productName = productName;
        this.dateOfPurchase = dateOfPurchase;
        this.causeForReturn = causeForReturn;
        this.address = address;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public String getCauseForReturn() {
        return causeForReturn;
    }

    public String getAddress() {
        return address;
    }
}
