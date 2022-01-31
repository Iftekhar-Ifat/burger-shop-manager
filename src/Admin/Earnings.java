package Admin;

import javax.swing.*;
import java.awt.*;

public class Earnings extends JFrame {
    public Earnings(){
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel background = new JLabel();
        background.setBounds(0,0,800,500);
        ImageIcon backImg = new ImageIcon("Images/Admin/Earnings/background.png");
        background.setIcon(backImg);
        add(background);

        int totalInvest = 45354;
        int totalRevenue = 96236;
        int totalExpense = 68654;

        JLabel investLabel = new JLabel(String.valueOf(totalInvest),SwingConstants.CENTER);
        investLabel.setBounds(26,146,190,150);
        investLabel.setForeground(Color.WHITE);
        investLabel.setFont(new Font("Arial", Font.BOLD, 36));
        background.add(investLabel);

        JLabel revenueLabel = new JLabel(String.valueOf(totalRevenue),SwingConstants.CENTER);
        revenueLabel.setBounds(230,146,190,150);
        revenueLabel.setForeground(Color.WHITE);
        revenueLabel.setFont(new Font("Arial", Font.BOLD, 36));
        background.add(revenueLabel);

        JLabel expenseLabel = new JLabel(String.valueOf(totalExpense),SwingConstants.CENTER);
        expenseLabel.setBounds(434,146,190,150);
        expenseLabel.setForeground(Color.WHITE);
        expenseLabel.setFont(new Font("Arial", Font.BOLD, 36));
        background.add(expenseLabel);

        JButton backBtn = new JButton();
        backBtn.setBounds(11, 10, 115,50);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon backIcon = new ImageIcon("Images/Buyer/Order Confirm/backBtn.png");
        backBtn.setIcon(backIcon);
        background.add(backBtn);

        backBtn.addActionListener( e -> {
            dispose();
            new Dashboard();
        });



        setVisible(true);
    }
}
