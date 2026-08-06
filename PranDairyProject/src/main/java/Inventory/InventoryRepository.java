package Inventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Optional;

public class InventoryRepository {

    private static final ObservableList<Inventory> STOCK = FXCollections.observableArrayList();

    private InventoryRepository() {
    }

    public static ObservableList<Inventory> getAllStock() {
        return STOCK;
    }

    public static void addStock(Inventory item) {
        STOCK.add(item);
    }

    public static Optional<Inventory> findByStockId(String stockId) {
        return STOCK.stream().filter(i -> i.getStockId().equalsIgnoreCase(stockId)).findFirst();
    }
}
