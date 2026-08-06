package PerformanceReport;

public class PerformanceReport {

    private final String reportPeriod;
    private final String totalDeliveries;
    private final String onTimeRate;

    public PerformanceReport(String reportPeriod, String totalDeliveries, String onTimeRate) {
        this.reportPeriod = reportPeriod;
        this.totalDeliveries = totalDeliveries;
        this.onTimeRate = onTimeRate;
    }

    public String getReportPeriod() {
        return reportPeriod;
    }

    public String getTotalDeliveries() {
        return totalDeliveries;
    }

    public String getOnTimeRate() {
        return onTimeRate;
    }
}
