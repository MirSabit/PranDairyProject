module com.example.prandairyproject {
    requires javafx.controls;
    requires javafx.fxml;

    // UI packages - opened to javafx.fxml for @FXML field/method injection,
    // and to javafx.base for TableView's PropertyValueFactory reflection.
    opens com.example.prandairyproject to javafx.fxml, javafx.base;
    opens CEO to javafx.fxml, javafx.base;
    opens Inventory_Manager to javafx.fxml, javafx.base;

    exports com.example.prandairyproject;
    exports CEO;
    exports Inventory_Manager;

    // Shared data packages (models + repositories) - not loaded by
    // FXMLLoader directly, but their getters are read reflectively by
    // TableView's PropertyValueFactory, so they need to be opened too.
    opens SalesReport to javafx.base;
    opens FinancialReport to javafx.base;
    opens ProfitLossSummary to javafx.base;
    opens ProductionTarget to javafx.base;
    opens ApproveSupplier to javafx.base;
    opens Employee to javafx.base;
    opens ComplaintReport to javafx.base;
    opens Product to javafx.base;
    opens Inventory to javafx.base;
    opens InventoryLog to javafx.base;
    opens MinimumStock to javafx.base;
    opens CustomerOrder to javafx.base;
    opens ReturnOrder to javafx.base;

    exports SalesReport;
    exports FinancialReport;
    exports ProfitLossSummary;
    exports ProductionTarget;
    exports ApproveSupplier;
    exports Employee;
    exports ComplaintReport;
    exports Product;
    exports Inventory;
    exports InventoryLog;
    exports MinimumStock;
    exports CustomerOrder;
    exports ReturnOrder;
}
