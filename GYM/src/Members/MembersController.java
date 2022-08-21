/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Members;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import gym_comp.GYM;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;
     


/**
 * FXML Controller class
 *
 * @author khaya
 */
public class MembersController implements Initializable {

    @FXML
    private TableColumn<Members, Integer> colmemberid;
    @FXML
    private TableColumn<Members, String> colname;
    @FXML
    private TableColumn<Members, String> colsurname;
    @FXML
    private TableColumn<Members, String> coldob;
    @FXML
    private TableColumn<Members, Integer> colid;
    @FXML
    private TableColumn<Members, Integer> colcontact;
    @FXML
    private TableColumn<Members, String> coldatejoined;
    @FXML
    private TableColumn<Members, String> colmembertype;
     @FXML
    private TableView<Members> membertbl;
     
    @FXML
    private TextField name; 
    @FXML
    private TextField memeberid; 
    @FXML
    private TextField id; 
    @FXML
    private TextField surname; 
    @FXML
    private TextField contact; 
    @FXML
    private DatePicker dob; 
    @FXML
    private DatePicker datejoined; 
    @FXML
    private ComboBox<String> membertype;
    
    ObservableList<String> list = FXCollections.observableArrayList("Annual" ,"Monthly");
    private final String pattern = "yyyy-MM-dd";
    
            StringConverter converter = new StringConverter<LocalDate>() {
                DateTimeFormatter dateFormatter = 
                    DateTimeFormatter.ofPattern(pattern);
                @Override
                public String toString(LocalDate date) {
                    if (date != null) {
                        return dateFormatter.format(date);
                    } else {
                        return "";
                    }
                }
                @Override
                public LocalDate fromString(String string) {
                    if (string != null && !string.isEmpty()) {
                        return LocalDate.parse(string, dateFormatter);
                    } else {
                        return null;
                    }
                }
            };      
            
                        @FXML
                        public void DeleteMember(MouseEvent event){
                        String  url ,user ,password ;
                        Connection con  = null;
                        PreparedStatement ps = null;
                        
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            url = "jdbc:mysql://localhost:3306/test";
                            user = "root";
                            password = "Khaya@130268";
                            con = DriverManager.getConnection(url,user ,password);
                           //MemberID ,Name ,Surname ,DateOfBirth ,ID ,Contact ,DateJoined ,Membertype , tblmembers
                            String sql = "DELETE  FROM tblmembers WHERE MemberID =?" ;
                            ps = con.prepareStatement(sql);
                            ps.setString(1 ,memeberid.getText());
                            int i = ps.executeUpdate();
                            if(i > 0){
                                Alert sms = new Alert(AlertType.INFORMATION);
                                sms.setTitle("Error : ");
                                sms.setHeaderText("Tracking Number : 061 147 2653  \n (!!!!!!Warning (Note that you are  using Metaploit (SSH) at your own risk))");
                                sms.setContentText("Account Number for (061 ********* 253 Succefully Found \n Account Type : Capitec Bank \n Account Number : ************* \n  Error : Cannot Get any Details Account Blocked");
                                sms.initStyle(StageStyle.DECORATED);
                                sms.showAndWait();
                                clear();
                                ShowMemebers();
                            }
                            
                            }catch(Exception e){
                                Alert sms = new Alert(AlertType.ERROR);
                                sms.setTitle("Error ");
                                sms.setHeaderText(" An Error Occured  while Trying to Delete  a Member in DataBase 😢😞 " +  "\n" + e.getMessage());
                                sms.setContentText("Failed to Delete");
                                sms.showAndWait();

                            }
                        
                        
                        }
                        
                        
                        @FXML
                        public void UpdateMmebers(MouseEvent event){
                        String  url ,user ,password ;
                        Connection con  = null;
                        PreparedStatement ps = null;
                        
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            url = "jdbc:mysql://localhost:3306/test";
                            user = "root";
                            password = "Khaya@130268";
                           con = DriverManager.getConnection(url,user ,password);
                           //MemberID ,Name ,Surname ,DateOfBirth ,ID ,Contact ,DateJoined ,Membertype , tblmembers
                            String sql = "UPDATE tblmembers SET Name ='" + name.getText() + "', Surname='" + surname.getText() +"', DateOfBirth ='"
                                    + ((TextField)dob.getEditor()).getText() + "',ID =" + id.getText() + ",Contact =" + contact.getText() +
                                    ", DateJoined ='"+ ((TextField)datejoined.getEditor()).getText() + "', Membertype='" + membertype.getValue() +"'" + "WHERE MemberID =" + memeberid.getText() ;
                            ps = con.prepareStatement(sql);
                            int i = ps.executeUpdate();
                            if(i >0){
                                ShowMemebers();
                                Alert sms = new Alert(AlertType.INFORMATION);
                                sms.setTitle("Updating");
                                sms.setHeaderText("Updating Memeber in Database ");
                                sms.setContentText("Memmber : " + name.getText().substring(0, 1).toUpperCase() +" " +surname.getText().toUpperCase() + "`s Details Have Been SuccessFully Updated ");
                                sms.showAndWait();
                                ShowMemebers();
                                clear();
                                
                            }else{
                                
                                Alert sms = new Alert(AlertType.ERROR);
                                sms.setTitle("Error , Update");
                                sms.setHeaderText("Failed to Update Member Data");
                                sms.setContentText("An Error Occured  ,Failed to Update Member  , Please Ty Again  ");
                                sms.showAndWait();
                            }
                            
                            }catch(Exception e){
                                Alert sms = new Alert(AlertType.ERROR);
                                sms.setTitle("Error ");
                                sms.setHeaderText(" An Error Occured  while Trying to Update  a Member in DataBase 😢😞 " +  "\n" + e.getMessage());
                                sms.setContentText("Failed to Update");
                                sms.showAndWait();

                            }
                            }
            

                        @FXML
                        public void Newmember(MouseEvent event){
                        
                        String  url ,user ,password ;
                        Connection con  = null;
                        PreparedStatement ps = null;

                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            url = "jdbc:mysql://localhost:3306/test";
                            user = "root";
                            password = "Khaya@130268";
                           con = DriverManager.getConnection(url,user ,password);
                            String sql = "INSERT INTO tblmembers (MemberID ,Name ,Surname ,DateOfBirth ,ID ,Contact ,DateJoined ,Membertype) values(?,?,?,?,?,?,?,?)";
                            ps = con.prepareStatement(sql);
                            ps.setString(1 , memeberid.getText());
                            ps.setString(2 , name.getText());
                            ps.setString(3 , surname.getText());
                            ps.setString(4 , ((TextField)dob.getEditor()).getText());
                            ps.setString(5 , id.getText());
                            ps.setString(6 , contact.getText());
                            ps.setString(7 , ((TextField)datejoined.getEditor()).getText());
                            ps.setString(8 , membertype.getValue());

                            int i = ps.executeUpdate();
                            
                            if(i > 0){
                                ShowMemebers();
                                Alert sms = new Alert(AlertType.INFORMATION);
                            sms.setTitle("Add Member");
                            sms.setHeaderText("Adding Memeber to Database ");
                            sms.setContentText("Memmber : " + name.getText().substring(0, 1).toUpperCase() +" " +surname.getText().toUpperCase() + " Has Beeen SuccessFully Added ");
                            sms.showAndWait();
                            ShowMemebers();
                               clear(); 
                            }else{
                             Alert sms = new Alert(AlertType.ERROR);
                            sms.setTitle("Error");
                            sms.setHeaderText(" An Error Occured ");
                            sms.setContentText("Failed to Add Member to DataBase , Please Ty Again ");
                            sms.showAndWait();

                            }


                            }catch(Exception e){
                            Alert sms = new Alert(AlertType.ERROR);
                            sms.setTitle("Error ");
                            sms.setHeaderText(" Error Occured  while Trying to Add a new  Member 😢😞 " +  "\n" + e.getMessage());
                            sms.setContentText("The New Member is  not Added");
                            sms.showAndWait();

                        }
                        }
                            public ObservableList<Members> getMemebersList(){
                            ObservableList<Members> memberList = FXCollections.observableArrayList();
                            String  url ,user ,password ;
                            Connection con  = null;
                            PreparedStatement ps = null;
                            Statement st;
                            ResultSet rs;

                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                url = "jdbc:mysql://localhost:3306/test";
                                user = "root";
                                password = "Khaya@130268";
                                con = DriverManager.getConnection(url,user ,password);
                                String sql = "SELECT * FROM tblmembers";
                                st = con.createStatement();
                                rs = st.executeQuery(sql);
                                Members members;
                               // MemberID, Name, Surname, DateOfBirth, ID, Contact, DateJoined, Membertype
                                    while(rs.next()){
                                    members = new Members(rs.getInt("MemberID") , rs.getString("Name") , rs.getString("Surname") , rs.getString("DateOfBirth") , rs.getInt("ID") ,
                                            rs.getInt("Contact") , rs.getString("DateJoined") , rs.getString("Membertype") );    
                                            memberList.add(members);
                                    }

                            }catch(Exception e){
                                   e.printStackTrace();
                            }
                            return memberList;
                            }
                                public void ShowMemebers(){
                                 ObservableList<Members> list = getMemebersList();
                                 colmemberid.setCellValueFactory(new PropertyValueFactory<Members ,Integer>("cmemberid"));
                                 colname.setCellValueFactory(new PropertyValueFactory<Members ,String>("cname"));
                                 colsurname.setCellValueFactory(new PropertyValueFactory<Members ,String>("csurname"));
                                 coldob.setCellValueFactory(new PropertyValueFactory<Members ,String>("cdob"));
                                 colid.setCellValueFactory(new PropertyValueFactory<Members ,Integer>("cid"));
                                 colcontact.setCellValueFactory(new PropertyValueFactory<Members ,Integer>("ccontatct"));
                                 coldatejoined.setCellValueFactory(new PropertyValueFactory<Members ,String>("cpaydate"));
                                 colmembertype.setCellValueFactory(new PropertyValueFactory<Members ,String>("cmembertype"));
                                 membertbl.setItems(list);
                                 


                                }
                                                                                                                    
                            @Override
                            public void initialize(URL url, ResourceBundle rb) {
                                // TODO
                            membertype.setItems(list);
                            dob.setConverter(converter);
                            datejoined.setConverter(converter);
                            ShowMemebers();
                            }    

    @FXML
    private void Ontableclick(MouseEvent event) {
        
        
    
        Members member = membertbl.getSelectionModel().getSelectedItem();
        memeberid.setText("" +member.getCmemberid());
        name.setText(member.getCname());
        surname.setText(member.getCsurname());
        ((TextField)dob.getEditor()).setText(member.getCdob());
        membertype.setValue(member.getCmembertype());
        id.setText(""+ member.getCid());
        contact.setText(""+ member.getCcontatct());
        ((TextField) datejoined.getEditor()).setText(member.getCpaydate());
    
    
    }

    @FXML
    private void clearFields(MouseEvent event) {
        clear();
    }
     public void clear(){
     
         memeberid.setText("");
        name.setText("");
        surname.setText("");
        ((TextField)dob.getEditor()).setText("");
        membertype.setValue("");
        id.setText("");
        contact.setText("");
        ((TextField) datejoined.getEditor()).setText("");
     
     
     }

    
    
}
