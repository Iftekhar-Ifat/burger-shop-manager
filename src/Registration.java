import javax.swing.*;
import java.awt.*;

public class Registration extends JFrame {
    Color maroon = new Color(36,1,1);
    Color burgerColor = new Color(255,153,0);
    Registration(){
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel leftCard = new JLabel();
        leftCard.setBounds(0,0,150,500);
        ImageIcon leftIcon = new ImageIcon("Images/Registration/leftCard.png");
        leftCard.setIcon(leftIcon);
        add(leftCard);

        JButton confirmBtn = new JButton();
        confirmBtn.setBounds(384,409,115,50);
        confirmBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon confirmBtnIcon = new ImageIcon("Images/Registration/confirmBtn.png");
        confirmBtn.setIcon(confirmBtnIcon);
        add(confirmBtn);

        JButton backBtn = new JButton();
        backBtn.setBounds(673,10,115,50);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon backBtnIcon = new ImageIcon("Images/Registration/backBtn.png");
        backBtn.setIcon(backBtnIcon);
        add(backBtn);

        backBtn.addActionListener( e -> {
            dispose();
            new LoginPage();
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

        JTextField passwordField = new JTextField();
        passwordField.setBounds(309,272,280,30);
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        passwordField.setFont(new Font("Arial", Font.BOLD, 18));
        passwordField.setForeground(burgerColor);
        passwordField.setCaretColor(burgerColor);
        passwordField.setBackground(maroon);
        add(passwordField);

        JTextField confirmPassField = new JTextField();
        confirmPassField.setBounds(309,338,280,30);
        confirmPassField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        confirmPassField.setFont(new Font("Arial", Font.BOLD, 18));
        confirmPassField.setForeground(burgerColor);
        confirmPassField.setCaretColor(burgerColor);
        confirmPassField.setBackground(maroon);
        add(confirmPassField);




        JLabel background = new JLabel();
        background.setBounds(150,0,650,500);
        ImageIcon backgroundIcon = new ImageIcon("Images/Registration/background.png");
        background.setIcon(backgroundIcon);
        add(background);




        setVisible(true);
    }
}
