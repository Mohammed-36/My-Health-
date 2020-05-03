/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author RemasTech
 */
public class MRemainderController implements Initializable {

    
    @FXML
    private TextField txttime;
    @FXML
    private TextField txtmidname;
    @FXML
    private Button btnstart;
    @FXML
    private Button btnback;
Integer currSeconds = 0;
    Thread thrd;
    int numberOfTime;
    int periodTime;
    String nameOfMed;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void start(ActionEvent event) {
        int d = Integer.parseInt(txttime.getText());
         String n = txtmidname.getText();
 numberOfTime = d ;
 currSeconds =  d*1000; //(24/d)*3600000;
 nameOfMed = n;
        this.startCountdown();
    }

    @FXML
    private void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    void startCountdown() {

        thrd = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    while (true) {

                        if (numberOfTime == 0) {

                            System.out.println("Finished");

                            Platform.runLater(() -> {

                                Alert msg = new Alert(Alert.AlertType.NONE);
                                msg.setTitle("Done");
                                msg.setHeaderText(null);
                                msg.getDialogPane().getButtonTypes().add(ButtonType.OK);
                                msg.setContentText("You took all your madicine for today");
                                msg.getDialogPane().setStyle(
                                        "-fx-background-position: center center; "
                                        + "-fx-background-repeat: stretch;");
                                msg.show();

                            });

                            thrd.stop(); 

                            // msg(); 
                        } else {

                            Thread.sleep(currSeconds);
                            //Thread.sleep(periodTime);
                            JOptionPane.showMessageDialog(null, "Medicine name:  "  + nameOfMed , "Alert : "+numberOfTime  , 3);
                            numberOfTime -= 1;
                            System.out.println(currSeconds);
                            System.out.println("number of cups : " + numberOfTime);
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("error");
                }
            }
        });
        thrd.start();
    }
}
