import javax.swing.*;

public class OrderConfirm extends JFrame {
    OrderConfirm(){
        setSize(816,539);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel background = new JLabel();
        background.setBounds(0,0,800,500);
        ImageIcon backImg = new ImageIcon("Images/Order Confirm/background.png");
        background.setIcon(backImg);
        add(background);

        JButton backBtn = new JButton();
        backBtn.setBounds(11, 10, 115,50);
        ImageIcon backIcon = new ImageIcon("Images/Order Confirm/backBtn.png");
        backBtn.setIcon(backIcon);
        background.add(backBtn);

        JButton logoutBtn = new JButton();
        logoutBtn.setBounds(667, 427, 115,50);
        ImageIcon logoutIcon = new ImageIcon("Images/Order Confirm/logoutBtn.png");
        logoutBtn.setIcon(logoutIcon);
        background.add(logoutBtn);


        setVisible(true);
    }


}
