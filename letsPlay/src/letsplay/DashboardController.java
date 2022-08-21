/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsplay;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Staff
 */
public class DashboardController implements Initializable {
    @FXML
    private TableView<Userdata> usertable;
    @FXML
    private TableColumn<Userdata, Integer> idcol;
    @FXML
    private TableColumn<Userdata, String> namecol;
    @FXML
    private TableColumn<Userdata, String> surnamecol;
    @FXML
    private TableColumn<Userdata, String> emailcol;
    @FXML
    private Button savebtn;
    @FXML
    private Button deletebtn;
    @FXML
    private Button clearbtn;
    @FXML
    private TextField id_;
    @FXML
    private TextField name_;
    @FXML
    private TextField lastname_;
    @FXML
    private TextField email_;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ShowUsers();
    } 
    
    
    public Connection GetConnection(){
        Connection conn ;
        try{
           conn = DriverManager.getConnection("jdbc:mysql://localhost:/test?" +"user=root&password=Khaya@130268" );
            return conn;
        
        }catch(Exception e){
            System.out.println(" error : "+ e.getMessage() );
            return conn = null;
        }
    
    }
    public  ObservableList<Userdata> GetUserList(){
        
        ObservableList<Userdata> userlist = FXCollections.observableArrayList() ;
        Connection conn = GetConnection();
        String sql = "SELECT * FROM users";
        Statement st;
        ResultSet rs;
        
        try{
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Userdata userdata;
            while(rs.next()){
                userdata = new Userdata(rs.getInt("user_id"),rs.getString("firtsname"),rs.getString("lastname"),rs.getString("email"));
                userlist.add(userdata);
            
            }
          
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return userlist;
        
        
        
        
    
    }
    
    public void  ShowUsers(){
        ObservableList<Userdata> list = GetUserList();
        
        idcol.setCellValueFactory(new PropertyValueFactory<Userdata ,Integer>("id"));
        namecol.setCellValueFactory(new PropertyValueFactory<Userdata , String>("firtstname"));
        surnamecol.setCellValueFactory(new PropertyValueFactory <Userdata,String>("lastname"));
        emailcol.setCellValueFactory(new PropertyValueFactory<Userdata,String>("email"));
        
        usertable.setItems(list);
    }

    @FXML
    private void Save(ActionEvent event) {
        
        try{
        PreparedStatement ps ;
        Connection conn = GetConnection();
        String sql = "INSERT INTO users(user_id,firtsname,lastname,email) values(?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, id_.getText());
        ps.setString(2, name_.getText());
        ps.setString(3, lastname_.getText());
        ps.setString(4, email_.getText());
        
        int i = ps.executeUpdate();
        if(i > 0){
        
        ShowUsers();
        }
        
        }catch(Exception e){
            System.out.println(e.getMessage() );
        
        
        }
        
        
    }

    @FXML
    private void Delete(ActionEvent event) {
    }

    @FXML
    private void Clear(ActionEvent event) {
    }
    
}
