package Seller;

import Buyer.OrderConfirm;

import javax.swing.*;
import java.awt.*;

public class SellerDashboard extends JFrame {
    public SellerDashboard(){
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel background = new JLabel();
        background.setBounds(0,0,800,500);
        ImageIcon backImg = new ImageIcon("Images/Admin/Dashboard/background.png");
        background.setIcon(backImg);
        add(background);

        JButton logoutBtn = new JButton();
        logoutBtn.setBounds(667,430,115,50);
        logoutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon logoutIcon = new ImageIcon("Images/Buyer/Order Confirm/logoutBtn.png");
        logoutBtn.setIcon(logoutIcon);
        background.add(logoutBtn);

        JButton addItemBtn = new JButton();
        addItemBtn.setBounds(100,160,200,150);
        addItemBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon addItemBtnIcon = new ImageIcon("Images/Seller/Seller Dashboard/addItemBtn.png");
        addItemBtn.setIcon(addItemBtnIcon);
        background.add(addItemBtn);

        JButton orderConfirmBtn = new JButton();
        orderConfirmBtn.setBounds(350,160,200,150);
        orderConfirmBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon orderConfirmBtnIcon = new ImageIcon("Images/Seller/Seller Dashboard/orderConfirmBtn.png");
        orderConfirmBtn.setIcon(orderConfirmBtnIcon);
        background.add(orderConfirmBtn);


        addItemBtn.addActionListener(e -> {
            dispose();
            new AddItem();
        });

        orderConfirmBtn.addActionListener(e -> {
            dispose();
            new ConfirmOrder();
        });

        setVisible(true);
    }
}
