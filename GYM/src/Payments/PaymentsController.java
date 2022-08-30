/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payments;

import Members.Members;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author khaya
 */
public class PaymentsController implements Initializable {

   
    @FXML
    private TextField paymentid;
    
    @FXML
    private TextField amount;
    
    @FXML
    private DatePicker paydate;
    
     @FXML
    private TableView<Payments> paytable;
    @FXML
    private TableColumn<Payments, Integer> payidcol;
    @FXML
    private TableColumn<Payments, String> paydatecol;
    @FXML
    private TableColumn<Payments, Integer> payamountcol;
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
            public void AddPay(MouseEvent event){
                String url ,user , password ;
                Connection con = null;
                PreparedStatement ps =null;

                try{
                        Class.forName("com.mysql.jdbc.Driver");
                        url = "jdbc:mysql://localhost:3306/test";
                        user = "root";
                        password = "password";
                        con = DriverManager.getConnection(url,user ,password);
                        String sql = "INSERT INTO tblpayments(PaymentsID, DatePay, Amount) values(?,?,?)";
                        ps = con.prepareStatement(sql);
                        ps.setString(1, paymentid.getText());
                        ps.setString(2, ((TextField)paydate.getEditor()).getText());
                        ps.setString(3, amount.getText());
                        int i = ps.executeUpdate();
                        
                        if(i > 0){
                        Alert sms = new Alert(Alert.AlertType.INFORMATION);
                        sms.setTitle("Payments");
                        sms.setHeaderText("Adding Member Payments to Database ");
                        sms.setContentText(" Payment Added SuccessFully ");
                        sms.showAndWait();
                        ShowPayments();
                        clear();
                        }else{
                        Alert sms = new Alert(Alert.AlertType.ERROR);
                        sms.setTitle("Error");
                        sms.setHeaderText("Save Error ");
                        sms.setContentText(" An Error Occured while trying to save data , Please Try Again ");
                        sms.showAndWait();
                        
                        }

                }catch(Exception e){
                        Alert sms = new Alert(Alert.AlertType.ERROR);
                            sms.setTitle("Payments-Error");
                            sms.setHeaderText("Error ");
                            sms.setContentText(" An Error Occured , Failed to Add Data to Data Base " + "\n" + e.getMessage());
                            sms.showAndWait();
                }    
                
                
            }
            @FXML
            public void UpdatePayment(MouseEvent event){
                Connection con;
                PreparedStatement ps;
                String url , password , user;
                    
                try{
                    
                     Class.forName("com.mysql.jdbc.Driver");
                        url = "jdbc:mysql://localhost:3306/test";
                        user = "root";
                        password = "Khaya@130268";
                        con = DriverManager.getConnection(url,user ,password);
                        //tblpayments(PaymentsID, DatePay, Amount) values
                        String sql = "UPDATE tblpayments SET DatePay='"+ ((TextField)paydate.getEditor()).getText() + "' ,Amount =" + amount.getText() + " WHERE PaymentsID =" + paymentid.getText() +"";
                        ps = con.prepareStatement(sql);
                        int i = ps.executeUpdate();
                        if(i > 0){
                        Alert sms = new Alert(Alert.AlertType.INFORMATION);
                        sms.setTitle("Payments");
                        sms.setHeaderText("Updating DataBase");
                        sms.setContentText(" Update Successful ");
                        sms.showAndWait();
                        ShowPayments();
                        clear();
                        }else{
                        Alert sms = new Alert(Alert.AlertType.ERROR);
                        sms.setTitle("Error");
                        sms.setHeaderText("Update Error ");
                        sms.setContentText(" An Error Occured while trying to update data , Please Try Again ");
                        sms.showAndWait();
                    
                        }
                    
                }catch(Exception e){
                        Alert sms = new Alert(Alert.AlertType.ERROR);
                            sms.setTitle("Payments-Update-Error");
                            sms.setHeaderText("Error ");
                            sms.setContentText(" An Error Occured , Failed to Update Data to Data Base " + "\n" + e.getMessage());
                            sms.showAndWait();
                }
                
            }
            @FXML
            public void deletePayment(MouseEvent event){
                
                Connection con;
                PreparedStatement ps;
                String url , password , user;
                    
                try{
                    
                     Class.forName("com.mysql.jdbc.Driver");
                        url = "jdbc:mysql://localhost:3306/test";
                        user = "root";
                        password = "password";
                        con = DriverManager.getConnection(url,user ,password);
                        //tblpayments(PaymentsID, DatePay, Amount) values
                        String sql = "DELETE FROM tblpayments WHERE PaymentsID=?";
                        ps = con.prepareStatement(sql);
                        ps.setString(1, paymentid.getText());
                        int i = ps.executeUpdate();
                        if(i > 0){
                        Alert sms = new Alert(Alert.AlertType.INFORMATION);
                        sms.setTitle("Payments-Delete");
                        sms.setHeaderText("Deleting Data in DataBase");
                        sms.setContentText(" Delete Successful ");
                        sms.showAndWait();
                        ShowPayments();
                        clear();
                        }else{
                        Alert sms = new Alert(Alert.AlertType.ERROR);
                        sms.setTitle("Error");
                        sms.setHeaderText("Delete Error ");
                        sms.setContentText(" An Error Occured while trying to Delete data , Please Try Again ");
                        sms.showAndWait();
                    
                        }
                    
                }catch(Exception e){
                        Alert sms = new Alert(Alert.AlertType.ERROR);
                            sms.setTitle("Payments-Delete-Error");
                            sms.setHeaderText("Error ");
                            sms.setContentText(" An Error Occured , Failed to delete Data from DataBase " + "\n" + e.getMessage());
                            sms.showAndWait();
                }
                
                
                
            }
            
            
             public ObservableList<Payments> getPaymentsList(){
                            ObservableList<Payments> payList = FXCollections.observableArrayList();
                            String  url ,user ,password ;
                            Connection con  = null;
                            PreparedStatement ps = null;
                            Statement st;
                            ResultSet rs;

                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                url = "jdbc:mysql://localhost:3306/test";
                                user = "root";
                                password = "password";
                                con = DriverManager.getConnection(url,user ,password);
                                String sql = "SELECT * FROM tblpayments";
                                st = con.createStatement();
                                rs = st.executeQuery(sql);
                                Payments payments;
                               //tblpayments(PaymentsID, DatePay, Amount) values
                                    while(rs.next()){
                                    payments = new Payments(rs.getInt("PaymentsID") , rs.getString("DatePay") , rs.getInt("Amount"));    
                                            payList.add(payments);
                                    }

                            }catch(Exception e){
                                   e.printStackTrace();
                            }
                            return payList;
                            }
                                public void ShowPayments(){
                                 ObservableList<Payments> list = getPaymentsList();
                                 payidcol.setCellValueFactory(new PropertyValueFactory<Payments ,Integer>("cpayid"));
                                 paydatecol.setCellValueFactory(new PropertyValueFactory<Payments ,String>("cpaydate"));
                                 payamountcol.setCellValueFactory(new PropertyValueFactory<Payments ,Integer>("Amount"));
                                 
                                 paytable.setItems(list);
                                 


                                }
                                  

    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        paydate.setConverter(converter);
        ShowPayments();
    }    

    @FXML
    private void OntableClick(MouseEvent event) {
        Payments payment = paytable.getSelectionModel().getSelectedItem();
        paymentid.setText(" " + payment.getCpayid());
        amount.setText(" " + payment.getAmount());
        ((TextField)paydate.getEditor()).setText(payment.getCpaydate());
        
    }

    @FXML
    private void clearFields(MouseEvent event) {
    clear();
    }
    public void clear(){
        paymentid.setText("");
        amount.setText("");
        ((TextField)paydate.getEditor()).setText("");
    
    }
    
}
