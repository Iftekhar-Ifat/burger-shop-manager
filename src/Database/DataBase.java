package Database;

import Admin.Dashboard;
import Authenticatio.LoginPage;
import Buyer.ItemPage;
import Seller.SellerDashboard;

import javax.swing.*;
import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    private Statement state;
    public DataBase(){
        String path = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/burger_shop_manager";
        try{
            Class.forName(path);
            Connection con = DriverManager.getConnection(url, "root", "");
            state = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void Insert(String query) throws SQLException {
        state.executeUpdate(query);
        state.close();
    }
    /* Login Page Functions Start...*/
    ResultSet resSet;
    public void checkLoginUser(String userQuery, String enteredName, String enteredPass, String userStat) {
        try {
            resSet = state.executeQuery(userQuery);
            boolean userExist = false;

            while(resSet.next()){
                String colUserEmail = resSet.getString(1);
                String colUserPass = resSet.getString(2);
                String colUserStatus = resSet.getString(3);
                if(enteredName.equals(colUserEmail) && enteredPass.equals(colUserPass) && userStat.equals(colUserStatus)){
                    userExist = true;
                    break;
                }
            }
            
            if(userExist && userStat.equals("buyer")){
                JOptionPane.showMessageDialog(null, "You are logged in \n");
                new ItemPage();
            }else if(userExist && userStat.equals("admin")){
                JOptionPane.showMessageDialog(null, "You are logged in \n");
                new Dashboard();
            }else if(userExist && userStat.equals("seller")){
                JOptionPane.showMessageDialog(null, "You are logged in \n");
                new SellerDashboard();
            }else{
                JOptionPane.showMessageDialog(null, "You are not a valid user \n");
                System.out.println(userStat);
                new LoginPage(userStat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String userStatus(String userQuery){
        try {
            resSet = state.executeQuery(userQuery);
            String status = "";
            while(resSet.next()){
                status = resSet.getString(1);
            }
            return status;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /* Login Page Functions End...*/


    /* Order Confirm Page Functions Start...*/
    public Object[][] orderConfirm(String userQuery, int databaseRow, int databaseCol){
        try {
            resSet = state.executeQuery(userQuery);
            Object[][] orderConfirmRow = new Object[databaseRow][databaseCol];
            int j = 0;
            while(resSet.next()){
                for(int i=0; i<databaseCol; i++){
                    orderConfirmRow[j][i] = resSet.getString(i+1);
                }
                j++;
            }
            return orderConfirmRow;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int totalRow(String userQuery){
        try {
            resSet = state.executeQuery(userQuery);
            int databaseRow = 0;
            while(resSet.next()){
                databaseRow++;
            }
            return databaseRow;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void updateTable(String userQuery){
        try {
            state.executeUpdate(userQuery);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteRow(String userQuery){
        try {
            state.executeUpdate(userQuery);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* Order Confirm Page Functions End...*/
}