package com.example.prandairyproject.Accountant;

public class SupplierPayment {

    private String paymentId;
    private String supplierId;
    private String supplierName;
    private String purchaseOrder;
    private double amount;
    private String paymentMethod;
    private String paymentDate;

    public SupplierPayment(String paymentId,
                           String supplierId,
                           String supplierName,
                           String purchaseOrder,
                           double amount,
                           String paymentMethod,
                           String paymentDate) {

        this.paymentId = paymentId;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.purchaseOrder = purchaseOrder;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getPurchaseOrder() {
        return purchaseOrder;
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
}