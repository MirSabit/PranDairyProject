package QualityReport;

public class QualityReport {

    private final String reportPeriod;
    private final String totalInspected;
    private final String totalApproved;
    private final String totalRejected;

    public QualityReport(String reportPeriod, String totalInspected, String totalApproved, String totalRejected) {
        this.reportPeriod = reportPeriod;
        this.totalInspected = totalInspected;
        this.totalApproved = totalApproved;
        this.totalRejected = totalRejected;
    }

    public String getReportPeriod() {
        return reportPeriod;
    }

    public String getTotalInspected() {
        return totalInspected;
    }

    public String getTotalApproved() {
        return totalApproved;
    }

    public String getTotalRejected() {
        return totalRejected;
    }
}
