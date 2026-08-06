package PaymentRecord;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PaymentRecordRepository {

    private static final ObservableList<PaymentRecord> RECORDS = FXCollections.observableArrayList();

    private PaymentRecordRepository() {
    }

    public static ObservableList<PaymentRecord> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(PaymentRecord record) {
        RECORDS.add(record);
    }
}
