package FeedbackResponse;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FeedbackResponseRepository {

    private static final ObservableList<FeedbackResponse> RECORDS = FXCollections.observableArrayList();

    private FeedbackResponseRepository() {
    }

    public static ObservableList<FeedbackResponse> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(FeedbackResponse record) {
        RECORDS.add(record);
    }
}
