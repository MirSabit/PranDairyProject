package Inventory_Manager;

import Product.Product;
import Product.ProductRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class product {

    @FXML
    private TextField productIdField;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField categoryField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, String> productIdColumn;

    @FXML
    private TableColumn<Product, String> productNameColumn;

    @FXML
    private TableColumn<Product, String> categoryColumn;

    @FXML
    private TableColumn<Product, String> descriptionColumn;

    @FXML
    public void initialize() {
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        productTable.setItems(ProductRepository.getAllProducts());
    }

    @FXML
    protected void addProduct() {
        String productId = productIdField.getText();
        String productName = productNameField.getText();

        if (productId == null || productId.isBlank() || productName == null || productName.isBlank()) {
            return;
        }

        ProductRepository.addProduct(new Product(
                productId,
                productName,
                emptyToDash(categoryField.getText()),
                emptyToDash(descriptionField.getText())));

        productIdField.clear();
        productNameField.clear();
        categoryField.clear();
        descriptionField.clear();
    }

    private String emptyToDash(String value) {
        return (value == null || value.isBlank()) ? "-" : value;
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("Inventory_Manager/Inventory_Dashboard.fxml", "Pran Dairy - Inventory Manager Dashboard");
    }
}
