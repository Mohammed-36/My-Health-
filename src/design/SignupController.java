/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hasoub
 */
public class SignupController implements Initializable {
Model m= new Model();
    @FXML
    private TextField txtFname;
    @FXML
    private TextField txtLname;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtMobil;
    @FXML
    private TextField txtage;
    @FXML
    private Button btnSave;
    @FXML
    private TextField txtusername;
    @FXML
    private TextField txtPass;
    @FXML
    private Button back;
    @FXML
    private Label labelout;
    @FXML
    private TextField txtgender;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save(ActionEvent event) throws IOException, SQLException {
         if(txtFname.getText().isEmpty()){
           labelout.setText("plz enter your first name");
        }else if(txtLname.getText().isEmpty()){
            labelout.setText("plz enter your last name ");
        }else if(txtEmail.getText().isEmpty()){
           labelout.setText("plz enter your email");
        }else if(txtMobil.getText().isEmpty()){
            labelout.setText("plz enter your phone number");
        }else if(txtage.getText().isEmpty()){
            labelout.setText("plz enter your phone number");
        }else if(txtusername.getText().isEmpty()){
            labelout.setText("plz enter your username");
        }else if(txtPass.getText().isEmpty()){
           labelout.setText("plz enter your Password");
        }else if(txtgender.getText().isEmpty()){
           labelout.setText("plz enter your Gender");
        }else{
          // Model m = new Model();
          m.registerUser(txtFname.getText(), txtLname.getText(), txtEmail.getText(), txtMobil.getText(),
                  txtage.getText(),txtusername.getText(),txtPass.getText(),txtgender.getText());
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        }
        
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
    private void gender(ActionEvent event) {
         
    }

    
}
