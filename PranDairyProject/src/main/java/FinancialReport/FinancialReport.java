package FinancialReport;


public class FinancialReport {

    private int reportID;
    private String quarter;
    private double revenue;
    private double expenses;
    private double profit;
    private double loss;

    public FinancialReport(int reportID, String quarter, double revenue, double expenses, double profit, double loss) {
        this.reportID = reportID;
        this.quarter = quarter;
        this.revenue = revenue;
        this.expenses = expenses;
        this.profit = profit;
        this.loss = loss;
    }

    public int getReportID() {
        return reportID;
    }

    public String getQuarter() {
        return quarter;
    }

    public double getRevenue() {
        return revenue;
    }

    public double getExpenses() {
        return expenses;
    }

    public double getProfit() {
        return profit;
    }

    public double getLoss() {
        return loss;
    }


    public String calculateGrowthRate() {
        if (expenses == 0) {
            return "N/A";
        }
        double growth = ((revenue - expenses) / expenses) * 100.0;
        return String.format("%.2f%%", growth);
    }
}
