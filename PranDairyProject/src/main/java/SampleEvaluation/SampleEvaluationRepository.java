package SampleEvaluation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SampleEvaluationRepository {

    private static final ObservableList<SampleEvaluation> RECORDS = FXCollections.observableArrayList();

    private SampleEvaluationRepository() {
    }

    public static ObservableList<SampleEvaluation> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(SampleEvaluation record) {
        RECORDS.add(record);
    }
}
