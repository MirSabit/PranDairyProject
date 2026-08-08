package ProfitLossSummary;


public class ProfitLossSummary {

    private String period;
    private double totalSales;
    private double totalCost;
    private double profit;

    public ProfitLossSummary(String period, double totalSales, double totalCost, double profit) {
        this.period = period;
        this.totalSales = totalSales;
        this.totalCost = totalCost;
        this.profit = profit;
    }

    public String getPeriod() {
        return period;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getProfit() {
        return profit;
    }
}
