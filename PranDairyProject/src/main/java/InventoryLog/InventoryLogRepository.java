package InventoryLog;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryLogRepository {

    private static final ObservableList<InventoryLog> LOG = FXCollections.observableArrayList();

    private InventoryLogRepository() {
    }

    public static ObservableList<InventoryLog> getLog() {
        return LOG;
    }

    public static void addEntry(InventoryLog entry) {
        LOG.add(0, entry);
    }
}
