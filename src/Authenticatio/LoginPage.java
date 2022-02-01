package Authenticatio;

import Database.DataBase;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {
    Color maroon = new Color(36,1,1);
    Color burgerColor = new Color(255,153,0);


    public LoginPage(String status){
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel background = new JLabel();
        background.setBounds(0,0,800,500);
        ImageIcon backImg = new ImageIcon("Images/Authentication/Login Page/background.png");
        background.setIcon(backImg);
        add(background);

        JTextField emailField = new JTextField();
        emailField.setBounds(309,171,280,30);
        emailField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        emailField.setFont(new Font("Arial", Font.BOLD, 18));
        emailField.setForeground(burgerColor);
        emailField.setCaretColor(burgerColor);
        emailField.setBackground(maroon);
        background.add(emailField);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(309,264,280,30);
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        passwordField.setFont(new Font("Arial", Font.BOLD, 18));
        passwordField.setForeground(burgerColor);
        passwordField.setCaretColor(burgerColor);
        passwordField.setBackground(maroon);
        background.add(passwordField);

        JButton loginBtn = new JButton();
        loginBtn.setBounds(309,370,115,50);
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon loginBtnIcon = new ImageIcon("Images/Authentication/Login Page/loginBtn.png");
        loginBtn.setIcon(loginBtnIcon);
        background.add(loginBtn);

        JButton registerBtn = new JButton();
        registerBtn.setBounds(474,370,115,50);
        registerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon registerBtnIcon = new ImageIcon("Images/Authentication/Login Page/regBtn.png");
        registerBtn.setIcon(registerBtnIcon);
        background.add(registerBtn);

        JButton backBtn = new JButton();
        backBtn.setBounds(673,10,115,50);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon backBtnIcon = new ImageIcon("Images/Authentication/Login Page/backBtn.png");
        backBtn.setIcon(backBtnIcon);
        background.add(backBtn);

        backBtn.addActionListener( e -> {
            dispose();
            new LoginMenu();
        });

        registerBtn.addActionListener( e -> {
            dispose();
            new Registration(status);
        });

        loginBtn.addActionListener(e -> {
            String userEmail = emailField.getText();
            String userPass = passwordField.getText();

            String userQuery = "SELECT `Email`,`Password`,`UserStatus` FROM `registration`";
            dispose();
            DataBase db = new DataBase();

            String userStatQuery = "SELECT `UserStatus` FROM `registration` WHERE `Email` = '"+userEmail+"' AND `Password` = '"+userPass+"'";

            String returnStat = db.userStatus(userStatQuery);

            if(returnStat.equals("seller")){
                db.checkLoginUser(userQuery, userEmail, userPass, "seller");
            }else{
                db.checkLoginUser(userQuery, userEmail, userPass, status);
            }

        });
        setVisible(true);

    }
}
