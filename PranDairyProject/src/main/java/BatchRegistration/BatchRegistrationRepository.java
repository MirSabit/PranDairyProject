package BatchRegistration;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BatchRegistrationRepository {

    private static final ObservableList<BatchRegistration> RECORDS = FXCollections.observableArrayList();

    private BatchRegistrationRepository() {
    }

    public static ObservableList<BatchRegistration> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(BatchRegistration record) {
        RECORDS.add(record);
    }
}
