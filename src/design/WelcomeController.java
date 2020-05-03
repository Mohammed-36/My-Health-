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
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hasoub
 */
public class WelcomeController implements Initializable {

    @FXML
    private Button btncal;
    @FXML
    private Button btnback;
    @FXML
    private Button btnfatburn;
    @FXML
    private Button medcaladvais;
    @FXML
    private Button btnwater;
    @FXML
    private Button btnmid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void calories(ActionEvent event)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BMI.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    

    @FXML
    private void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void fatburn(ActionEvent event)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Fatburn.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void advaic(ActionEvent event)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Medicaladvicer.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void waterremaider(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WaterReminder.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void medicinealarm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MRemainder.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }}
