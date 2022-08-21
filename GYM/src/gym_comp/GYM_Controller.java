/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym_comp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Members.MembersController;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Staff
 */
public class GYM_Controller implements Initializable {
 public static Stage stage = null;
    /**
     * Initializes the controller class.
     */
    @FXML
    private void MembersFrame(MouseEvent event) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("/Members/members.fxml"));
        Scene scene = new Scene(fxml);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        this.stage = stage;
    }
     @FXML
    private void DisplayFrame(MouseEvent event) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("/Display/Display.fxml"));
        Scene scene = new Scene(fxml);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        this.stage = stage;
    }
    @FXML
    private void Payments(MouseEvent event) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("/Payments/payments.fxml"));
        Scene scene = new Scene(fxml);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        this.stage = stage;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
