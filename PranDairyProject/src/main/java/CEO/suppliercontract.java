package CEO;

import ApproveSupplier.ApproveSupplier;
import ApproveSupplier.ApproveSupplierRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


public class suppliercontract {

    @FXML
    private TextField supplierIdField;

    @FXML
    private TextField contactInfoField;

    @FXML
    private TextField itemsSuppliedField;

    @FXML
    private TextField paymentMethodField;

    @FXML
    private TextField shippingTimeField;

    @FXML
    private RadioButton approveRadioButton;

    @FXML
    private RadioButton denyRadioButton;

    @FXML
    private Label statusLabel;

    @FXML
    protected void approveSupplierContract() {
        String supplierId = supplierIdField.getText();

        if (supplierId == null || supplierId.isBlank()) {
            statusLabel.setText("Please enter a Supplier ID.");
            return;
        }

        boolean approved = approveRadioButton.isSelected() && !denyRadioButton.isSelected();

        ApproveSupplierRepository.addSupplier(new ApproveSupplier(
                supplierId,
                contactInfoField.getText(),
                itemsSuppliedField.getText(),
                paymentMethodField.getText(),
                shippingTimeField.getText(),
                approved));

        statusLabel.setText("Supplier " + supplierId + " contract " + (approved ? "APPROVED." : "DENIED.") + " Saved.");

        supplierIdField.clear();
        contactInfoField.clear();
        itemsSuppliedField.clear();
        paymentMethodField.clear();
        shippingTimeField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("CEO/CEODashboard.fxml", "Pran Dairy - CEO Dashboard");
    }
}
