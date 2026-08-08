package ApproveSupplier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ApproveSupplierRepository {

    private static final ObservableList<ApproveSupplier> SUPPLIERS = FXCollections.observableArrayList();

    private ApproveSupplierRepository() {
    }

    public static ObservableList<ApproveSupplier> getAllSuppliers() {
        return SUPPLIERS;
    }

    public static void addSupplier(ApproveSupplier supplier) {
        SUPPLIERS.add(supplier);
    }
}
