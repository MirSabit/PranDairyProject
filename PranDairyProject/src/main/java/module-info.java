module csc213.prandairyproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens csc213.prandairyproject to javafx.fxml;
    exports csc213.prandairyproject;
}