package ComplaintInvestigation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ComplaintInvestigationRepository {

    private static final ObservableList<ComplaintInvestigation> RECORDS = FXCollections.observableArrayList();

    private ComplaintInvestigationRepository() {
    }

    public static ObservableList<ComplaintInvestigation> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(ComplaintInvestigation record) {
        RECORDS.add(record);
    }
}
