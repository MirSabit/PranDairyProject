package ComplaintReport;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Optional;

public class ComplaintReportRepository {

    private static final ObservableList<ComplaintReport> REPORTS = FXCollections.observableArrayList();

    private ComplaintReportRepository() {
    }

    public static ObservableList<ComplaintReport> getAllReports() {
        return REPORTS;
    }

    public static void addReport(ComplaintReport report) {
        REPORTS.add(report);
    }

    public static Optional<ComplaintReport> findByReportId(String reportId) {
        return REPORTS.stream().filter(r -> r.getReportId().equalsIgnoreCase(reportId)).findFirst();
    }
}
