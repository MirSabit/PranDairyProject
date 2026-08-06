package CustomerOrder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerOrderRepository {

    private static final ObservableList<CustomerOrder> ORDERS = FXCollections.observableArrayList();

    private CustomerOrderRepository() {
    }

    public static ObservableList<CustomerOrder> getAllOrders() {
        return ORDERS;
    }

    public static void addOrder(CustomerOrder order) {
        ORDERS.add(order);
    }
}
