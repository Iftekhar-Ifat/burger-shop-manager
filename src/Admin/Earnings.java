package Admin;

import javax.swing.*;
import java.awt.*;

public class Earnings extends JFrame {
    public Earnings(){
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        int totalInvest = 45354;

        JLabel investLable = new JLabel(String.valueOf(totalInvest),SwingConstants.CENTER);
        investLable.setBounds(26,146,190,150);
        investLable.setForeground(Color.WHITE);
        investLable.setFont(new Font("Arial", Font.BOLD, 36));
        add(investLable);

        JLabel background = new JLabel();
        background.setBounds(0,0,800,500);
        ImageIcon backImg = new ImageIcon("Images/Earnings/background.png");
        background.setIcon(backImg);
        add(background);


        setVisible(true);
    }
}
