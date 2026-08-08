package com.example.prandairyproject.Marketing_Officer;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CustomerAnalytics {

    private final SimpleStringProperty customerId;
    private final SimpleStringProperty customerName;
    private final SimpleIntegerProperty purchases;
    private final SimpleDoubleProperty totalSpent;
    private final SimpleStringProperty status;

    public CustomerAnalytics(String customerId,
                             String customerName,
                             int purchases,
                             double totalSpent,
                             String status) {

        this.customerId = new SimpleStringProperty(customerId);
        this.customerName = new SimpleStringProperty(customerName);
        this.purchases = new SimpleIntegerProperty(purchases);
        this.totalSpent = new SimpleDoubleProperty(totalSpent);
        this.status = new SimpleStringProperty(status);
    }

    public String getCustomerId() {
        return customerId.get();
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public int getPurchases() {
        return purchases.get();
    }

    public double getTotalSpent() {
        return totalSpent.get();
    }

    public String getStatus() {
        return status.get();
    }
}