/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsplay;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author Staff
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML 
    private TextField firstname;
    @FXML 
    private TextField lastname;
    @FXML 
    private PasswordField password;
    @FXML 
    private TextField email;
    @FXML 
    private TextField id;
    String url , pass , user;
    Connection conn = null;
    PreparedStatement ps = null;
    
    
    
    
    public void Connect(){
        
        try{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        conn =  DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                                   "user=root&password=password");
        
        
        
        }catch(Exception e){
            System.out.println("SQLException: " + e.getMessage());
    
        
    }
    }
    @FXML
    private void handleButtonAction(ActionEvent event) {
       Connect();
       try{
         String sql  = "INSERT INTO users(user_id ,firtsname , lastname ,email ,password_)VALUES(?,?,?,?,?)";
         ps = conn.prepareStatement(sql);
         ps.setString(1,id.getText());
         ps.setString(2,firstname.getText() );
         ps.setString(3,lastname.getText() );
         ps.setString(4,email.getText() );
         ps.setString(5,password.getText() );
         
       int i =  ps.executeUpdate();
       
       if(i > 0){
       Alert sms = new Alert(Alert.AlertType.CONFIRMATION);
       sms.setTitle("REGISTER");
       sms.setHeaderText("CREATING USER ACCOUNT");
       sms.setContentText("Account Created");
       sms.initStyle(StageStyle.DECORATED);
       sms.showAndWait();
       Stage pstage = (Stage)this.id.getScene().getWindow();
       pstage.close();
       OpenLoginPage(event);
       
        
       ps.close();
       conn.close();
       
       }
       
       }catch(Exception e){
       
           Alert sms = new Alert(Alert.AlertType.ERROR);
       sms.setTitle("ERROR");
       sms.setHeaderText("AN ERORR HAS OCCURED WHILE ATEMPTING TO CREATE ACCOUNT");
       sms.setContentText(" ERROR :" + e.getMessage());
       sms.initStyle(StageStyle.DECORATED);
       sms.showAndWait();
       }
       
    
       }
    
    
    public void OpenLoginPage(ActionEvent event) throws IOException{
        
    Stage stage = new Stage();
       Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void ExistingAccount(ActionEvent event) throws IOException{
    Stage pstage = (Stage)this.email.getScene().getWindow();
    pstage.close();
    Stage stage = new Stage();
       Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
