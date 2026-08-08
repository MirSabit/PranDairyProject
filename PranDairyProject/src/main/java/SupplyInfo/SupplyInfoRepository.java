package SupplyInfo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SupplyInfoRepository {

    private static final ObservableList<SupplyInfo> RECORDS = FXCollections.observableArrayList();

    private SupplyInfoRepository() {
    }

    public static ObservableList<SupplyInfo> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(SupplyInfo record) {
        RECORDS.add(record);
    }
}
