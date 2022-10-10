
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class InputjamController implements Initializable {

    @FXML
    private TextField input;
    
    @FXML
    private Button Submit;

    /**
     * Initializes the controller class.
     */
    boolean editdata = false;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  public void execute(modelcircuit d) {
        if (!String.valueOf(d.getCircuit()).isEmpty()) {
            
            editdata = true;
            txtinput.setText(d.getIdjam());
           
          
        } else {
        }
    }

    @FXML
    private void kliksimpan(ActionEvent event) {
        modeljam s = new modeljam();
       s.submit(intIdjam.getText());
        
       
        FXMLDocumentController.dtjam.setmodeljam(s);
        if (editdata) {
            if (FXMLDocumentController.dtjam.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil diubah", ButtonType.OK);
                a.showAndWait();
                input.setEditable(true);
//                klikbatal(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal diubah", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtjam.validasi(s.getIdjam()) >= 0) {
            System.out.println(FXMLDocumentController.dtjam.validasi(s.getcircuit()));
            if (FXMLDocumentController.dtjam.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil disimpan", ButtonType.OK);
                a.showAndWait();
//                klikbatal(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal disimpan", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data sudah ada", ButtonType.OK);
            a.showAndWait();
            input.requestFocus();
        }
    }
    
}
