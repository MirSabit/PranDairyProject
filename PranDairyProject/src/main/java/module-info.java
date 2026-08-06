module com.example.prandairyproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.prandairyproject to javafx.fxml, javafx.base;
    opens QualityControlOfficer to javafx.fxml, javafx.base;
    opens Supplier to javafx.fxml, javafx.base;

    exports com.example.prandairyproject;
    exports QualityControlOfficer;
    exports Supplier;

    opens RawMilkInspection to javafx.base;
    opens ProductQualityCheck to javafx.base;
    opens QualityReport to javafx.base;
    opens ComplaintInvestigation to javafx.base;
    opens ExpiryCheck to javafx.base;
    opens SampleEvaluation to javafx.base;
    opens HygieneInspection to javafx.base;
    opens LabRecord to javafx.base;
    opens Delivery to javafx.base;
    opens PaymentRecord to javafx.base;
    opens SupplyInfo to javafx.base;
    opens DeliveryHistory to javafx.base;
    opens BatchRegistration to javafx.base;
    opens DeliverySchedule to javafx.base;
    opens FeedbackResponse to javafx.base;
    opens PerformanceReport to javafx.base;

    exports RawMilkInspection;
    exports ProductQualityCheck;
    exports QualityReport;
    exports ComplaintInvestigation;
    exports ExpiryCheck;
    exports SampleEvaluation;
    exports HygieneInspection;
    exports LabRecord;
    exports Delivery;
    exports PaymentRecord;
    exports SupplyInfo;
    exports DeliveryHistory;
    exports BatchRegistration;
    exports DeliverySchedule;
    exports FeedbackResponse;
    exports PerformanceReport;
}
