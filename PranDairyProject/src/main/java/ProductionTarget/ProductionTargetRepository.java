package ProductionTarget;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductionTargetRepository {

    private static final ObservableList<ProductionTarget> TARGETS = FXCollections.observableArrayList();

    private ProductionTargetRepository() {
    }

    public static ObservableList<ProductionTarget> getAllTargets() {
        return TARGETS;
    }

    public static void addTarget(ProductionTarget target) {
        TARGETS.add(target);
    }
}
