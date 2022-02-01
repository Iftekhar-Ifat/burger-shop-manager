package Authenticatio;

import Database.DataBase;

import javax.swing.*;
import java.awt.*;

public class LoginMenu extends JFrame {
    public LoginMenu() {
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel leftCard = new JLabel();
        leftCard.setBounds(0,0,341,500);
        ImageIcon leftIcon = new ImageIcon("Images/Authentication/Login Menu/leftCard.png");
        leftCard.setIcon(leftIcon);
        add(leftCard);

        JLabel rightCard = new JLabel();
        rightCard.setBounds(341,0,459,500);
        ImageIcon rightIcon = new ImageIcon("Images/Authentication/Login Menu/rightCard.png");
        rightCard.setIcon(rightIcon);
        add(rightCard);

        JButton adminBtn = new JButton();
        adminBtn.setBounds(50,400,79,29);
        adminBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon adminIcon = new ImageIcon("Images/Authentication/Login Menu/adminBtn.png");
        adminBtn.setIcon(adminIcon);
        rightCard.add(adminBtn);

        JButton sellerBtn = new JButton();
        sellerBtn.setBounds(190,400,79,29);
        sellerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon sellerIcon = new ImageIcon("Images/Authentication/Login Menu/sellerBtn.png");
        sellerBtn.setIcon(sellerIcon);
        rightCard.add(sellerBtn);

        JButton buyerBtn = new JButton();
        buyerBtn.setBounds(330,400,79,29);
        buyerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon buyerIcon = new ImageIcon("Images/Authentication/Login Menu/buyerBtn.png");
        buyerBtn.setIcon(buyerIcon);
        rightCard.add(buyerBtn);

        adminBtn.addActionListener( e -> {
            dispose();
            new LoginPage("admin");
        });

        sellerBtn.addActionListener( e -> {
            dispose();
            System.out.println("seller");
            new LoginPage("pending");
        });

        buyerBtn.addActionListener( e -> {
            dispose();
            new LoginPage("buyer");
        });

        setVisible(true);
    }
}
