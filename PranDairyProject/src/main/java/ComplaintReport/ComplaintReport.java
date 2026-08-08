package ComplaintReport;

public class ComplaintReport {

    private String reportId;
    private int totalComplaints;
    private String resolvedComplaints;

    public ComplaintReport(String reportId, int totalComplaints, String resolvedComplaints) {
        this.reportId = reportId;
        this.totalComplaints = totalComplaints;
        this.resolvedComplaints = resolvedComplaints;
    }

    public String getReportId() {
        return reportId;
    }

    public int getTotalComplaints() {
        return totalComplaints;
    }

    public String getResolvedComplaints() {
        return resolvedComplaints;
    }
}
