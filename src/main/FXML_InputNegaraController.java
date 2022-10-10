
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
public class FXML_InputNegaraController implements Initializable {

    @FXML
    private TextField intIdNegara;
    @FXML
    private TextField txtNamaNegara;
    @FXML
    private Button btnsimpan;

    /**
     * Initializes the controller class.
     */
    boolean editdata = false;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  public void execute(modelNegara d) {
        if (!String.valueOf(d.getIdnegara()).isEmpty()) {
            
            editdata = true;
            intIdNegara.setText(d.getIdnegara());
            txtNamaNegara.setText(d.getIdnegara());
          
        } else {
        }
    }

    @FXML
    private void kliksimpan(ActionEvent event) {
        modelNegara s = new modelNegara();
       s.setIdnegara(intIdNegara.getText());
        s.setNegara(txtNamaNegara.getText());
       
        FXMLDocumentController.dtnegara.setmodelNegara(s);
        if (editdata) {
            if (FXMLDocumentController.dtnegara.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil diubah", ButtonType.OK);
                a.showAndWait();
                intIdNegara.setEditable(true);
//                klikbatal(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal diubah", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtnegara.validasi(s.getIdnegara()) >= 0) {
            System.out.println(FXMLDocumentController.dtnegara.validasi(s.getIdnegara()));
            if (FXMLDocumentController.dtnegara.insert()) {
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
            intIdNegara.requestFocus();
        }
    }
    
}
