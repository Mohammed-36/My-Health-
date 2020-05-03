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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author RemasTech
 */
public class WaterReminderController implements Initializable {

    @FXML
    private Button btncal;
    @FXML
    private Button btnback;
    @FXML
    private TextField txttime;
    @FXML
    private TextField txtmillilater;

    Integer currSeconds = 0;
    Thread thrd;
    int periodTime;
    int numberOfCups;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void calculate(ActionEvent event) {

        int d = Integer.parseInt(txttime.getText());
              int t = Integer.parseInt(txtmillilater.getText());
             
        

//        for (int i = 0; i <= d * 60000; i++) {
//
//            System.out.println("1");
//
//        }
//        System.out.println("Done");
        currSeconds=d*1000;
        numberOfCups = t;
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

                        if (numberOfCups == 0) {

                            System.out.println("Finished");

                            Platform.runLater(() -> {

                                Alert msg = new Alert(Alert.AlertType.NONE);
                                msg.setTitle("Done");
                                msg.setHeaderText(null);
                                msg.getDialogPane().getButtonTypes().add(ButtonType.OK);
                                msg.setContentText("Good job");
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
                            JOptionPane.showMessageDialog(null, "Number of cups: "+ numberOfCups, "Alert : " , 3);
                            
                            numberOfCups -= 1;
                            System.out.println(currSeconds);
                            System.out.println("number of cups : " + numberOfCups);
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
