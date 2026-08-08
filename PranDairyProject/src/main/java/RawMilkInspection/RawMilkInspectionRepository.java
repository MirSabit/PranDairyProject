package RawMilkInspection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RawMilkInspectionRepository {

    private static final ObservableList<RawMilkInspection> RECORDS = FXCollections.observableArrayList();

    private RawMilkInspectionRepository() {
    }

    public static ObservableList<RawMilkInspection> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(RawMilkInspection record) {
        RECORDS.add(record);
    }
}
