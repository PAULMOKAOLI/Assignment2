module com.example.assign2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.assign2 to javafx.fxml;
    exports com.example.assign2;
}