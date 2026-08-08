package com.example.prandairyproject.Accountant;

public class Expense {

    private String expenseId;
    private String category;
    private String description;
    private double amount;
    private String date;
    private String paidTo;

    public Expense(String expenseId, String category, String description,
                   double amount, String date, String paidTo) {
        this.expenseId = expenseId;
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.paidTo = paidTo;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getPaidTo() {
        return paidTo;
    }
}