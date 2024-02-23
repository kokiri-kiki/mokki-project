package org.example.mokkiproject;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static javax.swing.JOptionPane.showMessageDialog;


public class MokkiController {

    public Button TestDBConnectionController;
    public TextField LisataAlue;
    public TextArea SearchResults;
    public TextField HakeaAlueita;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AlueHakeaButton;

    @FXML
    private Button AlueLisataButton;

    @FXML
    private Button AlueMuokataButton;

    @FXML
    private Button AluePoistaaButton;

    @FXML
    private Button MokkiHakeaButton;

    @FXML
    private Button MokkiLisataButton;

    @FXML
    private Button MokkiMuokataButton;

    @FXML
    private Button MokkiPoistaaButton;

    @FXML
    void initialize() {
        
    }

    public void ConnectDB(ActionEvent actionEvent) throws SQLException {
        DB.DB_connect();
    }

    public void SaveText(ActionEvent actionEvent) {
        String message = LisataAlue.getText();
        showMessageDialog(null, message);
    }

    public void SaveToDB(ActionEvent actionEvent) throws SQLException {
        String message = "INSERT INTO alue (nimi) VALUES ('" + LisataAlue.getText() + "')";
        DB.DBinsert(message);
    }

    public void SearchDB(ActionEvent actionEvent) throws SQLException {
        String message = "SELECT * FROM alue WHERE nimi LIKE '%" + HakeaAlueita.getText() + "%'";

        SearchResults.setText(DB.DBsearch(message));

    }
}
