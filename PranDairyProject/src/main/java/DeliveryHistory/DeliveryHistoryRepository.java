package DeliveryHistory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DeliveryHistoryRepository {

    private static final ObservableList<DeliveryHistory> RECORDS = FXCollections.observableArrayList();

    private DeliveryHistoryRepository() {
    }

    public static ObservableList<DeliveryHistory> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(DeliveryHistory record) {
        RECORDS.add(record);
    }
}
