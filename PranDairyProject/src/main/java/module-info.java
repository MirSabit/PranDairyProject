module com.example.prandairyproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.prandairyproject to javafx.fxml;
    exports com.example.prandairyproject;

    opens com.example.prandairyproject.Marketing_Officer to javafx.fxml;
    exports com.example.prandairyproject.Marketing_Officer;
}