package com.example.prandairyproject.Accountant;

public class FinancialReport {

    private String reportType;
    private String period;
    private double revenue;
    private double expenses;
    private double grossProfit;
    private double netProfit;
    private double profitMargin;

    public FinancialReport(String reportType,
                           String period,
                           double revenue,
                           double expenses,
                           double grossProfit,
                           double netProfit,
                           double profitMargin) {

        this.reportType = reportType;
        this.period = period;
        this.revenue = revenue;
        this.expenses = expenses;
        this.grossProfit = grossProfit;
        this.netProfit = netProfit;
        this.profitMargin = profitMargin;
    }

    public String getReportType() {
        return reportType;
    }

    public String getPeriod() {
        return period;
    }

    public double getRevenue() {
        return revenue;
    }

    public double getExpenses() {
        return expenses;
    }

    public double getGrossProfit() {
        return grossProfit;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public double getProfitMargin() {
        return profitMargin;
    }
}