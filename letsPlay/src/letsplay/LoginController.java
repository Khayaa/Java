/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsplay;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Staff
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField email;
    @FXML
    private PasswordField pass;
    
    @FXML
    public void Login(ActionEvent event){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        
        try{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection("jdbc:mysql://localhost:/test?" + "user=root&password=password");
        sql = "SELECT * FROM users WHERE email = ? and password_ =  ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, email.getText());
        ps.setString(2, pass.getText());
        rs = ps.executeQuery();
        
        if(rs.next()){
            
                Alert sms = new Alert(Alert.AlertType.CONFIRMATION);
       sms.setTitle("Login Successful");
       sms.setHeaderText("WELCOME ");
       sms.setContentText("-------------------------");
       sms.initStyle(StageStyle.DECORATED);
       sms.showAndWait();
       
 
       Stage pstage = (Stage)this.email.getScene().getWindow();
       pstage.close();
       ShowDashboard(event);
       
       
       }
        
        ps.close();
        rs.close();
        conn.close();
        }catch(Exception e){
        Alert sms = new Alert(Alert.AlertType.ERROR);
       sms.setTitle("ERROR");
       sms.setHeaderText("AN ERORR HAS OCCURED WHILE ATEMPTING TO CREATE ACCOUNT");
       sms.setContentText(" ERROR :" + e.getMessage());
       sms.initStyle(StageStyle.DECORATED);
       sms.showAndWait();
        
        }
        
    
    }
    
     public  void ShowDashboard(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
