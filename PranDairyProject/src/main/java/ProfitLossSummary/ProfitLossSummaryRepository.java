package ProfitLossSummary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProfitLossSummaryRepository {

    private static final ObservableList<ProfitLossSummary> SUMMARIES = FXCollections.observableArrayList();

    private ProfitLossSummaryRepository() {
    }

    public static ObservableList<ProfitLossSummary> getAllSummaries() {
        return SUMMARIES;
    }

    public static void addSummary(ProfitLossSummary summary) {
        SUMMARIES.add(summary);
    }
}
