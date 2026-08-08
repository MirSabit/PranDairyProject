package com.example.prandairyproject.Accountant;

public class FinancialDashboard {

    private String category;
    private double amount;

    public FinancialDashboard(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}