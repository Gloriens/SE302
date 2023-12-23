module com.example.syllabusmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.syllabusmanager to javafx.fxml;
    exports com.example.syllabusmanager;
}