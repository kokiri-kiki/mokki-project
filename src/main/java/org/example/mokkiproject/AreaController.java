package org.example.mokkiproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AreaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddAreaController;

    @FXML
    private TextField Area_field;

    @FXML
    private Button SearchAreaController;

    @FXML
    private TextField Search_field;

    @FXML
    private TextArea Search_results_area;

    @FXML
    void initialize() {
        AddAreaController.setOnAction(event ->{
            System.out.println("Вы нажади кнопку Добавить");
        });
    }

}
