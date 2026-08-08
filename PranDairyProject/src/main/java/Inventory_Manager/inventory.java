package Inventory_Manager;

import Inventory.Inventory;
import Inventory.InventoryRepository;
import InventoryLog.InventoryLog;
import InventoryLog.InventoryLogRepository;
import com.example.prandairyproject.SceneManager;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;


public class inventory {

    @FXML
    private TextField newStockIdField;

    @FXML
    private TextField newProductNameField;

    @FXML
    private TextField newCurrentStockField;

    @FXML
    private TextField newMinThresholdField;

    @FXML
    private TextField newLocationField;

    @FXML
    private TextField searchField;

    @FXML
    private TextField quantityField;

    @FXML
    private TableView<Inventory> stockTable;

    @FXML
    private TableColumn<Inventory, String> stockIdColumn;

    @FXML
    private TableColumn<Inventory, String> productNameColumn;

    @FXML
    private TableColumn<Inventory, Number> currentStockColumn;

    @FXML
    private TableColumn<Inventory, Number> minThresholdColumn;

    @FXML
    private TableColumn<Inventory, String> locationColumn;

    @FXML
    private TableColumn<Inventory, String> availabilityColumn;

    private FilteredList<Inventory> filteredStock;

    @FXML
    public void initialize() {
        stockIdColumn.setCellValueFactory(new PropertyValueFactory<>("stockId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        currentStockColumn.setCellValueFactory(new PropertyValueFactory<>("currentStock"));
        minThresholdColumn.setCellValueFactory(new PropertyValueFactory<>("minThreshold"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        filteredStock = new FilteredList<>(InventoryRepository.getAllStock(), s -> true);
        stockTable.setItems(filteredStock);
    }

    @FXML
    protected void addStock() {
        String stockId = newStockIdField.getText();
        String productName = newProductNameField.getText();
        String currentStockText = newCurrentStockField.getText();
        String minThresholdText = newMinThresholdField.getText();
        String location = newLocationField.getText();

        if (stockId == null || stockId.isBlank() || currentStockText == null || currentStockText.isBlank()
                || minThresholdText == null || minThresholdText.isBlank()) {
            return;
        }

        int currentStock;
        int minThreshold;
        try {
            currentStock = Integer.parseInt(currentStockText.trim());
            minThreshold = Integer.parseInt(minThresholdText.trim());
        } catch (NumberFormatException e) {
            return;
        }

        InventoryRepository.addStock(new Inventory(
                stockId,
                emptyToDash(productName),
                currentStock,
                minThreshold,
                emptyToDash(location),
                "Available"));

        newStockIdField.clear();
        newProductNameField.clear();
        newCurrentStockField.clear();
        newMinThresholdField.clear();
        newLocationField.clear();
    }

    @FXML
    protected void searchStock() {
        String search = searchField.getText();
        if (search == null || search.isBlank()) {
            filteredStock.setPredicate(s -> true);
            return;
        }
        String lowerSearch = search.trim().toLowerCase();
        filteredStock.setPredicate(s -> s.getStockId().toLowerCase().contains(lowerSearch)
                || s.getProductName().toLowerCase().contains(lowerSearch));
    }

    @FXML
    protected void viewLowStockAlerts() {
        filteredStock.setPredicate(Inventory::isLowStock);
    }

    @FXML
    protected void showAllStock() {
        searchField.clear();
        filteredStock.setPredicate(s -> true);
    }

    @FXML
    protected void updateStock() {
        Inventory selected = stockTable.getSelectionModel().getSelectedItem();
        String quantityText = quantityField.getText();

        if (selected == null || quantityText == null || quantityText.isBlank()) {
            return;
        }

        int delta;
        try {
            delta = Integer.parseInt(quantityText.trim());
        } catch (NumberFormatException e) {
            return;
        }

        selected.setCurrentStock(selected.getCurrentStock() + delta);
        stockTable.refresh();

        InventoryLogRepository.addEntry(new InventoryLog(
                selected.getStockId(),
                LocalDate.now().toString(),
                (delta >= 0 ? "+" : "") + delta,
                "Stock updated manually"));

        quantityField.clear();
    }

    @FXML
    protected void restockProduct() {
        Inventory selected = stockTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            return;
        }

        int restockAmount = Math.max(selected.getMinThreshold() * 2, 1) - selected.getCurrentStock();
        if (restockAmount <= 0) {
            return;
        }

        selected.setCurrentStock(selected.getCurrentStock() + restockAmount);
        stockTable.refresh();

        InventoryLogRepository.addEntry(new InventoryLog(
                selected.getStockId(),
                LocalDate.now().toString(),
                "+" + restockAmount,
                "Product restocked"));
    }

    @FXML
    protected void changeAvailability() {
        Inventory selected = stockTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            return;
        }

        String newAvailability = "Available".equals(selected.getAvailability()) ? "Unavailable" : "Available";
        selected.setAvailability(newAvailability);
        stockTable.refresh();

        InventoryLogRepository.addEntry(new InventoryLog(
                selected.getStockId(),
                LocalDate.now().toString(),
                "0",
                "Availability changed to " + newAvailability));
    }

    private String emptyToDash(String value) {
        return (value == null || value.isBlank()) ? "-" : value;
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("Inventory_Manager/Inventory_Dashboard.fxml", "Pran Dairy - Inventory Manager Dashboard");
    }
}
