package ProductQualityCheck;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductQualityCheckRepository {

    private static final ObservableList<ProductQualityCheck> RECORDS = FXCollections.observableArrayList();

    private ProductQualityCheckRepository() {
    }

    public static ObservableList<ProductQualityCheck> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(ProductQualityCheck record) {
        RECORDS.add(record);
    }
}
