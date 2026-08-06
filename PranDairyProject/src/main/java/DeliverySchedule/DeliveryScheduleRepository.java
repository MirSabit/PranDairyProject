package DeliverySchedule;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DeliveryScheduleRepository {

    private static final ObservableList<DeliverySchedule> RECORDS = FXCollections.observableArrayList();

    private DeliveryScheduleRepository() {
    }

    public static ObservableList<DeliverySchedule> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(DeliverySchedule record) {
        RECORDS.add(record);
    }
}
