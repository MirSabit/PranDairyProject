package HygieneInspection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HygieneInspectionRepository {

    private static final ObservableList<HygieneInspection> RECORDS = FXCollections.observableArrayList();

    private HygieneInspectionRepository() {
    }

    public static ObservableList<HygieneInspection> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(HygieneInspection record) {
        RECORDS.add(record);
    }
}
