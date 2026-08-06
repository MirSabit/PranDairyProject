package LabRecord;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LabRecordRepository {

    private static final ObservableList<LabRecord> RECORDS = FXCollections.observableArrayList();

    private LabRecordRepository() {
    }

    public static ObservableList<LabRecord> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(LabRecord record) {
        RECORDS.add(record);
    }
}
