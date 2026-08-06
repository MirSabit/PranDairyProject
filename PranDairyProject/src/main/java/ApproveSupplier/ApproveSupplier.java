package ApproveSupplier;

public class ApproveSupplier {

    private String supplierId;
    private String contactInfo;
    private String itemsSupplied;
    private String paymentMethod;
    private String shippingTime;
    private boolean approved;

    public ApproveSupplier(String supplierId, String contactInfo, String itemsSupplied,
                            String paymentMethod, String shippingTime, boolean approved) {
        this.supplierId = supplierId;
        this.contactInfo = contactInfo;
        this.itemsSupplied = itemsSupplied;
        this.paymentMethod = paymentMethod;
        this.shippingTime = shippingTime;
        this.approved = approved;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getItemsSupplied() {
        return itemsSupplied;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getShippingTime() {
        return shippingTime;
    }

    public boolean isApproved() {
        return approved;
    }

    public String getStatus() {
        return approved ? "Approved" : "Denied";
    }
}
