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
public class DisplayjamController implements Initializable {

    @FXML
    private TableView<modeljam> tbvjam;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        ObservableList<modeljam> data = FXMLDocumentController.dtjam.Load();
        if (data != null) {
            tbvjam.getColumns().clear();
            tbvjam.getItems().clear();
            TableColumn col = new TableColumn("jam");
            col.setCellValueFactory(new PropertyValueFactory<modeljam, String>("jam"));
            tbvjam.getColumns().addAll(col);
            tbvjam.setItems(data);
        } else {

            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvjam.getScene().getWindow().hide();;

        }

   
    }    

    @FXML
    private void backclick(ActionEvent event) {
    }
    
}
