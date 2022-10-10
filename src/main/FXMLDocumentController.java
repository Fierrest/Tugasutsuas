/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class FXMLDocumentController implements Initializable {
    public static DBNegara dtnegara = new DBNegara();
     public static DBcircuit dtcircuit = new DBcircuit();
      public static DBjam dtjam = new DBjam();
    private Label label;
    @FXML
    private MenuItem inputNegaraKlik;
    @FXML
    private Menu dsiplayNegaraKlik;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void inputNegaraKlik(ActionEvent event) {
        try{  FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML_InputNegara.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }

    @FXML
    private void dsiplayNegaraKlik(ActionEvent event) {
    }
    
}
