package CEO;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class annualproductionfxmlcontroller
{
    @javafx.fxml.FXML
    private TextField TextboxSetYear;
    @javafx.fxml.FXML
    private TextField TextfieldItemID;
    @javafx.fxml.FXML
    private TableColumn<annualproduction,String>TableviewItemCategory;
    @javafx.fxml.FXML
    private TableColumn<annualproduction,Integer> TableviewItemID;
    @javafx.fxml.FXML
    private TableColumn <annualproduction,Integer>TableViewYear;
    @javafx.fxml.FXML
    private ComboBox <String>ComboboxItermCategory;
    @javafx.fxml.FXML
    private TextField TextboxSetItemTarget;
    @javafx.fxml.FXML
    private TableColumn <annualproduction,Integer>TableViewTarget;
    @javafx.fxml.FXML
    private TableColumn <annualproduction,Integer>TableViewFinalProduction;
    @javafx.fxml.FXML
    private Button ButtonShowannualproduction;
    ArrayList<annualproduction> productionlist = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        ComboboxItermCategory.getItems().addAll("Yougurt","Milk","IceCream","UHTMilk");

        TableviewItemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        TableviewItemCategory.setCellValueFactory(new PropertyValueFactory<>("item_category"));
        TableViewYear.setCellValueFactory((new PropertyValueFactory<>("year")));
        TableViewFinalProduction.setCellValueFactory(new PropertyValueFactory<>(""));
        TableViewTarget.setCellValueFactory(new PropertyValueFactory<>("item_target"));

    }

    @javafx.fxml.FXML
    public void showannualproduction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        String item_category = ComboboxItermCategory.getValue();


        int itemID = Integer.parseInt(TextfieldItemID.getText());



        int year = Integer.parseInt(TextboxSetItemTarget.getText());


        int item_target = Integer.parseInt(TextboxSetItemTarget.getText());

        if (item_category == null){
            alert.setContentText("Please Select an Item Category");
            alert.showAndWait();
            return;
        }
        if (itemID == 0){
            alert.setContentText("Please Enter an Item ID");
            alert.showAndWait();
            return;
        }
        if (year == 0){
            alert.setContentText("Enter a Valid year");
            alert.showAndWait();
            return;
        }
        if (item_target < 0){
            alert.setContentText("Please Select a Valid Value");
            alert.showAndWait();
            return;
        }
        annualproduction a = new annualproduction(itemID,year,item_category,item_target);

        productionlist.add(a);
    }
}