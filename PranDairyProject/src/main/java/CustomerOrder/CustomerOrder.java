package CustomerOrder;


public class CustomerOrder {

    private String customerId;
    private String customerName;
    private String productName;
    private String productId;
    private String total;

    public CustomerOrder(String customerId, String customerName, String productName, String productId, String total) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.productName = productName;
        this.productId = productId;
        this.total = total;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }

    public String getTotal() {
        return total;
    }
}
