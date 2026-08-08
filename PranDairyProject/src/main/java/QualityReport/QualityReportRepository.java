package QualityReport;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QualityReportRepository {

    private static final ObservableList<QualityReport> RECORDS = FXCollections.observableArrayList();

    private QualityReportRepository() {
    }

    public static ObservableList<QualityReport> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(QualityReport record) {
        RECORDS.add(record);
    }
}
