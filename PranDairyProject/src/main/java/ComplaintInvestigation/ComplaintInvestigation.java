package ComplaintInvestigation;

public class ComplaintInvestigation {

    private final String ticketId;
    private final String customerName;
    private final String productName;
    private final String rootCause;
    private final String correctiveAction;

    public ComplaintInvestigation(String ticketId, String customerName, String productName, String rootCause, String correctiveAction) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.productName = productName;
        this.rootCause = rootCause;
        this.correctiveAction = correctiveAction;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public String getRootCause() {
        return rootCause;
    }

    public String getCorrectiveAction() {
        return correctiveAction;
    }
}
