/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RemasTech
 */
public class SwimController implements Initializable {

    @FXML
    private TextField txtdays;
    @FXML
    private TextField txtmin;
    @FXML
    private Button btncal;
    @FXML
    private Label lblout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goback(ActionEvent event)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Fatburn.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
}

    @FXML
    private void calculateit(ActionEvent event) {
        if(txtdays.getText().isEmpty()){
           lblout.setText("please enter your Day ");
        }else if(txtmin.getText().isEmpty()){
            lblout.setText("please enter your Minute ");
        
    }  
        int  d = Integer.parseInt(txtdays.getText()); 
            
          int  m = Integer.parseInt(txtmin.getText());
            
            double  Caloties = d * m * 11.66;
            
           lblout.setText(String.valueOf(Caloties));
    }
    
}
