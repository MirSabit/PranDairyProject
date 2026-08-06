package Delivery;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DeliveryRepository {

    private static final ObservableList<Delivery> RECORDS = FXCollections.observableArrayList();

    private DeliveryRepository() {
    }

    public static ObservableList<Delivery> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(Delivery record) {
        RECORDS.add(record);
    }
}
