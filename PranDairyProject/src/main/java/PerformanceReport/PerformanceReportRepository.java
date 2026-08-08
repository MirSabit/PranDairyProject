package PerformanceReport;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PerformanceReportRepository {

    private static final ObservableList<PerformanceReport> RECORDS = FXCollections.observableArrayList();

    private PerformanceReportRepository() {
    }

    public static ObservableList<PerformanceReport> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(PerformanceReport record) {
        RECORDS.add(record);
    }
}
