package Authentication;

import Database.DataBase;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class Registration extends JFrame {
    Color maroon = new Color(36,1,1);
    Color burgerColor = new Color(255,153,0);
    Registration(String status){
        System.out.println(status);
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Burger Shop Manager");
        ImageIcon appIcon = new ImageIcon("../Images/appIcon.png");
        this.setIconImage(appIcon.getImage());
        


        JLabel leftCard = new JLabel();
        leftCard.setBounds(0,0,150,500);
        ImageIcon leftIcon = new ImageIcon("../Images/Authentication/Registration/leftCard.png");
        leftCard.setIcon(leftIcon);
        add(leftCard);

        JButton confirmBtn = new JButton();
        confirmBtn.setBounds(384,409,115,50);
        confirmBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon confirmBtnIcon = new ImageIcon("../Images/Authentication/Registration/confirmBtn.png");
        confirmBtn.setIcon(confirmBtnIcon);
        add(confirmBtn);

        JButton backBtn = new JButton();
        backBtn.setBounds(673,10,115,50);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon backBtnIcon = new ImageIcon("../Images/Authentication/Registration/backBtn.png");
        backBtn.setIcon(backBtnIcon);
        add(backBtn);

        backBtn.addActionListener( e -> {
            dispose();
            new LoginPage(status);
        });

        JTextField nameField = new JTextField();
        nameField.setBounds(309,59,280,30);
        nameField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        nameField.setFont(new Font("Arial", Font.BOLD, 18));
        nameField.setForeground(burgerColor);
        nameField.setCaretColor(burgerColor);
        nameField.setBackground(maroon);
        add(nameField);

        JTextField emailField = new JTextField();
        emailField.setBounds(309,129,280,30);
        emailField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        emailField.setFont(new Font("Arial", Font.BOLD, 18));
        emailField.setForeground(burgerColor);
        emailField.setCaretColor(burgerColor);
        emailField.setBackground(maroon);
        add(emailField);

        JTextField mobileField = new JTextField();
        mobileField.setBounds(309,201,280,30);
        mobileField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mobileField.setFont(new Font("Arial", Font.BOLD, 18));
        mobileField.setForeground(burgerColor);
        mobileField.setCaretColor(burgerColor);
        mobileField.setBackground(maroon);
        add(mobileField);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(309,272,280,30);
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        passwordField.setFont(new Font("Arial", Font.BOLD, 18));
        passwordField.setForeground(burgerColor);
        passwordField.setCaretColor(burgerColor);
        passwordField.setBackground(maroon);
        add(passwordField);

        JPasswordField confirmPassField = new JPasswordField();
        confirmPassField.setBounds(309,338,280,30);
        confirmPassField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        confirmPassField.setFont(new Font("Arial", Font.BOLD, 18));
        confirmPassField.setForeground(burgerColor);
        confirmPassField.setCaretColor(burgerColor);
        confirmPassField.setBackground(maroon);
        add(confirmPassField);

        JLabel background = new JLabel();
        background.setBounds(150,0,650,500);
        ImageIcon backgroundIcon = new ImageIcon("../Images/Authentication/Registration/background.png");
        background.setIcon(backgroundIcon);
        add(background);


        confirmBtn.addActionListener(e ->{
            String name = nameField.getText();
            String email = emailField.getText();
            String mobile = mobileField.getText();
            String password = passwordField.getText();

            String userNameRegEx = "^[a-zA-Z._ ]+$";
            String passRegEx = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$?&_\\-]).{6,20}";
            String emailRegEx = "^[a-z0-9_]+@[a-z]+.+[a-z]+$";
            String mobileRegEx = "(\\+88)?-?01[3-9]\\d{8}";

            if(!Pattern.matches(userNameRegEx, name)){
                JOptionPane.showMessageDialog(null, "Invalid User Name\n");
            }else if(!Pattern.matches(emailRegEx, email)){
//                System.out.println(email);
                JOptionPane.showMessageDialog(null, "Invalid E-mail!");
            }else if(!Pattern.matches(mobileRegEx, mobile)){
                JOptionPane.showMessageDialog(null, "Invalid Mobile Number\n");
            }else if(!Pattern.matches(passRegEx, password)){
                System.out.println(password);
                JOptionPane.showMessageDialog(null, "Invalid Password\nYour password must contain\n1-digit\n1-special char\n1-upper case\n1-lower case");
            }else {
                String sqlQuery = "INSERT INTO `registration`(`Name`, `Email`, `Mobile`, `Password`, `UserStatus`) "
                        + "VALUES ('"+name+"','"+email+"','"+mobile+"','"+password+"','"+status+"')";
                DataBase db = new DataBase();
                try {
                    db.Insert(sqlQuery);
                    JOptionPane.showMessageDialog(null,"Registration confirmed");
                    dispose();
                    new LoginPage(status);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } 
            }
        });
        setVisible(true);
    }
}
