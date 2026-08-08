package FinancialReport;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FinancialReportRepository {

    private static final ObservableList<FinancialReport> REPORTS = FXCollections.observableArrayList();

    private FinancialReportRepository() {
    }

    public static ObservableList<FinancialReport> getAllReports() {
        return REPORTS;
    }

    public static void addReport(FinancialReport report) {
        REPORTS.add(report);
    }
}
