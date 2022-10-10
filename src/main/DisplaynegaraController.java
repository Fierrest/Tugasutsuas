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
public class DisplaynegaraController implements Initializable {

    @FXML
    private TableView<modelNegara> tbvnegara;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<modelNegara> data = FXMLDocumentController.dtnegara.Load();
        if (data != null) {
            tbvnegara.getColumns().clear();
            tbvnegara.getItems().clear();
            TableColumn col = new TableColumn("IdNegara");
            
            col.setCellValueFactory(new PropertyValueFactory<modelNegara, String>("IdNegara"));
            tbvnegara.getColumns().addAll(col);
             col = new TableColumn("Negara");
            
            col.setCellValueFactory(new PropertyValueFactory<modelNegara, String>("Negara"));
            tbvnegara.getColumns().addAll(col);
            tbvnegara.setItems(data);
        } else {

            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvnegara.getScene().getWindow().hide();;

        }

    }
       

    @FXML
    private void backclick(ActionEvent event) {
    }
    
}
