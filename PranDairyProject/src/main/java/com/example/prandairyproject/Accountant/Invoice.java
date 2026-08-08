package com.example.prandairyproject.Accountant;

public class Invoice {

    private String invoiceId;
    private String customerName;
    private String orderId;
    private double amount;
    private String issueDate;
    private String dueDate;
    private String status;

    public Invoice(String invoiceId,
                   String customerName,
                   String orderId,
                   double amount,
                   String issueDate,
                   String dueDate,
                   String status) {

        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.orderId = orderId;
        this.amount = amount;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}