module com.example.shopvideocard {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.shopvideocard to javafx.fxml;
    exports com.example.shopvideocard;
}