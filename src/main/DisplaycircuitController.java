/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Fierrest Eyliem
 */
public class DisplaycircuitController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private TableView<modelcircuit> tbvcircuit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<modelcircuit> data = FXMLDocumentController.dtcircuit.Load();
        if (data != null) {
            tbvcircuit.getColumns().clear();
            tbvcircuit.getItems().clear();
            TableColumn col = new TableColumn("circuit");
            col.setCellValueFactory(new PropertyValueFactory<modelcircuit, String>("circuit"));
            tbvcircuit.getColumns().addAll(col);
            tbvcircuit.setItems(data);
        } else {

            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvcircuit.getScene().getWindow().hide();;

        }

    }

    @FXML
    private void backclick(ActionEvent event) {
    }
}
