package Database;

import Admin.Dashboard;
import Authenticatio.LoginPage;
import Buyer.ItemPage;

import javax.swing.*;
import java.sql.*;
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

    ResultSet resSet;
    public void checkLoginUser(String userQuery, String enteredName, String enteredPass, String userStat) {
        try {
            resSet = state.executeQuery(userQuery);
            boolean userExist = false;
            while(resSet.next()){
                String colUserName = resSet.getString(1);
                String colUserPass = resSet.getString(2);
                String colUserStatus = resSet.getString(3);

                if(enteredName.equals(colUserName) && enteredPass.equals(colUserPass) && userStat.equals(colUserStatus)){
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
                new ItemPage();
            }else{
                JOptionPane.showMessageDialog(null, "You are not a valid user \n");
                new LoginPage(userStat);
            }



        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}