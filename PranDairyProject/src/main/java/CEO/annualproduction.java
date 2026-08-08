package CEO;

import ProductionTarget.ProductionTarget;
import ProductionTarget.ProductionTargetRepository;
import com.example.prandairyproject.SceneManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class annualproduction {

    @FXML
    private TextField itemIdField;

    @FXML
    private ComboBox<String> itemCategoryComboBox;

    @FXML
    private TextField targetField;

    @FXML
    private TextField yearField;

    @FXML
    private TableView<ProductionTarget> productionTable;

    @FXML
    private TableColumn<ProductionTarget, String> itemIdColumn;

    @FXML
    private TableColumn<ProductionTarget, String> itemCategoryColumn;

    @FXML
    private TableColumn<ProductionTarget, String> targetColumn;

    @FXML
    private TableColumn<ProductionTarget, String> yearColumn;

    @FXML
    public void initialize() {
        itemCategoryComboBox.setItems(FXCollections.observableArrayList(
                "Milk", "Cheese", "Butter", "Yogurt", "Ghee", "Cream"));

        itemIdColumn.setCellValueFactory(new PropertyValueFactory<>("targetID"));
        itemCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        targetColumn.setCellValueFactory(new PropertyValueFactory<>("targetQuantity"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        productionTable.setItems(ProductionTargetRepository.getAllTargets());
    }

    @FXML
    protected void setAnnualProductionTarget() {
        String itemId = itemIdField.getText();
        String category = itemCategoryComboBox.getValue();
        String target = targetField.getText();
        String year = yearField.getText();

        if (itemId == null || itemId.isBlank() || target == null || target.isBlank() || year == null || year.isBlank()) {
            return;
        }

        ProductionTargetRepository.addTarget(new ProductionTarget(itemId, category == null ? "" : category, year, target));

        itemIdField.clear();
        targetField.clear();
        yearField.clear();
        itemCategoryComboBox.getSelectionModel().clearSelection();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("CEO/CEODashboard.fxml", "Pran Dairy - CEO Dashboard");
    }
}
