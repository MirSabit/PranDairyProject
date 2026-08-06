package SalesReport;

public class salesreport {

    private int reportID;
    private String time;
    private String category;
    private int totalSales;
    private float growthRate;

    public salesreport(int reportID, String time, String category, int totalSales, float growthRate) {
        this.reportID = reportID;
        this.time = time;
        this.category = category;
        this.totalSales = totalSales;
        this.growthRate = growthRate;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    public float getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(float growthRate) {
        this.growthRate = growthRate;
    }

    /**
     * Matches the totalsale() method on the UML SalesReport class.
     * Formats totalSales for display.
     */
    public String totalsale() {
        return String.format("$%,d", totalSales);
    }

    /**
     * Matches the growthrate() method on the UML SalesReport class.
     * Formats growthRate for display.
     */
    public String growthrate() {
        return String.format("%.2f%%", growthRate);
    }
}
