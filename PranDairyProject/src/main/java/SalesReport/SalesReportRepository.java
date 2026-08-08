package SalesReport;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class SalesReportRepository {

    private static final ObservableList<salesreport> REPORTS = FXCollections.observableArrayList();

    private SalesReportRepository() {
    }

    public static ObservableList<salesreport> getAllReports() {
        return REPORTS;
    }

    public static void addReport(salesreport report) {
        REPORTS.add(report);
    }
}
