package ExpiryCheck;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExpiryCheckRepository {

    private static final ObservableList<ExpiryCheck> RECORDS = FXCollections.observableArrayList();

    private ExpiryCheckRepository() {
    }

    public static ObservableList<ExpiryCheck> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(ExpiryCheck record) {
        RECORDS.add(record);
    }
}
