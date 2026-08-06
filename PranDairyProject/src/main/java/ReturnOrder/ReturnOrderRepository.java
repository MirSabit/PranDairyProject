package ReturnOrder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReturnOrderRepository {

    private static final ObservableList<ReturnOrder> RETURNS = FXCollections.observableArrayList();

    private ReturnOrderRepository() {
    }

    public static ObservableList<ReturnOrder> getAllReturns() {
        return RETURNS;
    }

    public static void addReturn(ReturnOrder returnOrder) {
        RETURNS.add(returnOrder);
    }
}
