package com.example.prandairyproject.Accountant;

public class PaymentRecord {

    private String transactionId;
    private String customerId;
    private String orderId;
    private double amount;
    private String paymentMethod;
    private String paymentDate;
    private String status;

    public PaymentRecord(String transactionId,
                         String customerId,
                         String orderId,
                         double amount,
                         String paymentMethod,
                         String paymentDate,
                         String status) {

        this.transactionId = transactionId;
        this.customerId = customerId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getStatus() {
        return status;
    }
}