package com.example.syllabusmanager;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
public class Help_Controller {

    @FXML
    private Button createSylHelpButton;

    @FXML
    private Button importhelpButton;

    @FXML
    private Button exportHelpButton;


    @FXML
    private void initialize() {
        createSylHelpButton.setOnAction(actionEvent -> createHelp());
        importhelpButton.setOnAction(actionEvent -> helponImport());
        exportHelpButton.setOnAction(actionEvent -> helponExport());
    }


    @FXML
    void createHelp() {
        String helpText = "Click the 'Create Syllabus' button and enter the required information into the text fields.\n"
                + "In the 'Course/Program Outcome Matrix' section, input the outcomes relevant to your department and indicate which outcomes your course addresses. "
                + "Select the contribution level (if applicable) and then click the 'Add' button. "
                + "Once you're done, click 'Save' to save the syllabus.";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
<<<<<<< Updated upstream
        alert.setTitle("Add Button");
        alert.setHeaderText("How can I add CV?");
=======
        alert.setTitle("Create Syllabus");
        alert.setHeaderText("How can I create Syllabus?");
>>>>>>> Stashed changes
        alert.setContentText(helpText);
        alert.show();

    }

    @FXML
    void helponImport() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
<<<<<<< Updated upstream
        alert.setTitle("Delete Button");
        alert.setHeaderText("How can I delete CV?");
        alert.setContentText("To delete a CV, you should select a row on the table and \nthen click the delete button.");
=======

>>>>>>> Stashed changes
        alert.show();

    }

    @FXML
    void helponExport(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
<<<<<<< Updated upstream
        alert.setTitle("Edit Button");
        alert.setHeaderText("How can I edit CV?");
        alert.setContentText("To edit a CV, firstly, you need select a row from the \ntable, once a row selected, the information about that CV \nis printed in the boxes on the bottom. So, you can edit \nthe information in the boxes and then click edit when \nediting is done");
=======
>>>>>>> Stashed changes
        alert.show();

    }
}