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
public class BMIController implements Initializable {

    @FXML
    private Label lblout;
    @FXML
    private Button btncalculat;
    @FXML
    private TextField txtweight;
    @FXML
    private TextField txtheight;
    @FXML
    private Label lbloutstatus;
    @FXML
    private Button btnback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Weight(ActionEvent event) {
    }

    @FXML
    private void Height(ActionEvent event) {
        
    }

    @FXML
    private void calculat(ActionEvent event) {
        if(txtweight.getText().isEmpty()){
           lblout.setText("please enter your Weight ");
        }else if(txtheight.getText().isEmpty()){
            lblout.setText("please enter your Height ");
        
    }
            double  w = Double.parseDouble(txtweight.getText()); 
            
             double  h = Double.parseDouble(txtheight.getText());
             
            double  IBM = (w / (h*h) *10000);
            
           lblout.setText(String.valueOf(IBM));
        
    if(IBM <=18.5 ){
           lbloutstatus.setText(" Underweight ");
    }else if(18.6<= IBM && IBM <= 24.9){
         lbloutstatus.setText(" Normal weight ");
    }else if (25 <= IBM && IBM <= 29.9){
        lbloutstatus.setText(" Overweight ");
    }else {
        lbloutstatus.setText(" Obesity ");
}}

    @FXML
    private void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
}}
