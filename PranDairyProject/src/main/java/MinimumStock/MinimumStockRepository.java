package MinimumStock;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class MinimumStockRepository {

    private static final ObservableList<MinimumStock> RECORDS = FXCollections.observableArrayList();

    private MinimumStockRepository() {
    }

    public static ObservableList<MinimumStock> getAllRecords() {
        return RECORDS;
    }

    public static void addRecord(MinimumStock record) {
        RECORDS.add(record);
    }

    public static List<MinimumStock> findByProductId(String productId) {
        return RECORDS.stream()
                .filter(r -> r.getProductId().equalsIgnoreCase(productId))
                .collect(Collectors.toList());
    }
}
