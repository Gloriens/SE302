module com.example.syllabusmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.syllabusmanager to javafx.fxml;
    exports com.example.syllabusmanager;
}