package Admin;

import javax.swing.*;
import java.awt.*;

public class RemoveSeller extends JFrame {
    public RemoveSeller(){
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel background = new JLabel();
        background.setBounds(0,0,800,500);
        ImageIcon backImg = new ImageIcon("Images/Admin/Remove Seller/background.png");
        background.setIcon(backImg);
        add(background);

        JButton backBtn = new JButton();
        backBtn.setBounds(11, 10, 115,50);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon backIcon = new ImageIcon("Images/Buyer/Order Confirm/backBtn.png");
        backBtn.setIcon(backIcon);
        background.add(backBtn);

        JButton removeBtn = new JButton();
        removeBtn.setBounds(295, 422, 115,50);
        removeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon removeIcon = new ImageIcon("Images/Admin/Remove Seller/removeBtn.png");
        removeBtn.setIcon(removeIcon);
        background.add(removeBtn);

        backBtn.addActionListener( e -> {
            dispose();
            new Dashboard();
        });

        setVisible(true);
    }
}
