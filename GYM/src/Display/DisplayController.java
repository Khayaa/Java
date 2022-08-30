/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import Members.Members;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khaya
 */
public class DisplayController implements Initializable {

    @FXML
    private TableView<Display> tblresults;
    
    @FXML
    private TableColumn<Display, Integer> id;
    @FXML
    private TableColumn<Display, String> name;
    @FXML
    private TableColumn<Display, String> surname;
    @FXML
    private TableColumn<Display, String> DOB;
    @FXML
    private TableColumn<Display, Integer> age;
    @FXML
    private TableColumn<Display, Integer> amountdue;
    @FXML
    private TableColumn<Display, Integer> amountpaid;
    @FXML
    private TableColumn<Display, Integer> balance;
    /**
     * Initializes the controller class.
     */
    
                        public ObservableList<Display> getDispplayList(){
                            ObservableList<Display> DisplayList = FXCollections.observableArrayList();
                            String  url ,user ,password ;
                            Connection con  = null;
                            PreparedStatement ps = null;
                            Statement st;
                            ResultSet rs;

                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                url = "jdbc:mysql://localhost:3306/test";
                                user = "root";
                                password = "";
                                con = DriverManager.getConnection(url,user ,password);
                                String sql = "select tblmembers.ID ,tblmembers.Name , tblmembers.Surname ,tblmembers.DateOfBirth , \n" +
                                        "timestampdiff(YEAR ,tblmembers.DateOfBirth , curdate()) AS AGE,\n" +
                                        "if(tblmembers.Membertype = 'Annual' , @Amount :=  + (timestampdiff(YEAR ,tblmembers.DateJoined , curdate()) * 200)  , \n" +
                                        " @Amount :=  + (timestampdiff(month ,tblmembers.DateJoined , curdate()) * 50 )) as AmountDue\n" +
                                        ",tblpayments.Amount As Amountpaid, (@Amount - tblpayments.Amount) as Balance\n" +
                                        "FROM tblmembers\n" +
                                        "JOIN tblpayments\n" +
                                        "ON tblmembers.MemberID = tblpayments.PaymentsID";
                                st = con.createStatement();
                                rs = st.executeQuery(sql);
                                Display display;
                               // MemberID,  Name, Surname, DateOfBirth, AGE, AmountDue, Amountpaid, Balance
                                    while(rs.next()){
                                    display = new Display(rs.getInt("tblmembers.ID") , rs.getString("tblmembers.Name") , rs.getString("tblmembers.Surname") , rs.getString("tblmembers.DateOfBirth") , rs.getInt("AGE") ,
                                            rs.getInt("AmountDue") , rs.getInt("Amountpaid") , rs.getInt("Balance") );    
                                            DisplayList.add(display);
                                    }

                            }catch(Exception e){
                                   e.printStackTrace();
                            }
                            return DisplayList;
                            }
                                public void ShowDisplay(){
                                 
                               ObservableList<Display> list = getDispplayList();
                                 id.setCellValueFactory(new PropertyValueFactory<Display ,Integer>("cid"));
                                 name.setCellValueFactory(new PropertyValueFactory<Display ,String>("cname"));
                                 surname.setCellValueFactory(new PropertyValueFactory<Display ,String>("csurname"));  
                                 DOB.setCellValueFactory(new PropertyValueFactory<Display ,String>("cdob"));
                                 age.setCellValueFactory(new PropertyValueFactory<Display ,Integer>("cage"));
                                 amountdue.setCellValueFactory(new PropertyValueFactory<Display ,Integer>("camountdue"));
                                 amountpaid.setCellValueFactory(new PropertyValueFactory<Display ,Integer>("camountpaid"));
                                 balance.setCellValueFactory(new PropertyValueFactory<Display ,Integer>("cbalance"));
                                 tblresults.setItems(list);
                                }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ShowDisplay();
    
    }    
    
}
