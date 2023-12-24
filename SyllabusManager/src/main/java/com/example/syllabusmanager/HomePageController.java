package com.example.syllabusmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button createSyllabusButton;

    @FXML
    private AnchorPane homePage;

    @FXML
    private Button exitButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button exit;

    @FXML
    private void createSyllabusAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateSyllabus.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Create Syllabus");

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.setWidth(1300);
            stage.setHeight(800); //was 1000

            stage.setResizable(true); //was false


            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        // Uygulamadan çıkış işlemleri burada yapılabilir
        System.exit(0);
    }

    @FXML
    private void compare(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("compare.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Help");

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openHelp(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("help.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Help");

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}