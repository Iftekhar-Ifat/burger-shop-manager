import javax.swing.*;

public class LoginMenu extends JFrame {
    LoginMenu() {
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel leftCard = new JLabel();
        leftCard.setBounds(0,0,341,500);
        ImageIcon leftIcon = new ImageIcon("Images/Login Menu/leftCard.png");
        leftCard.setIcon(leftIcon);
        add(leftCard);

        JLabel rightCard = new JLabel();
        rightCard.setBounds(341,0,459,500);
        ImageIcon rightIcon = new ImageIcon("Images/Login Menu/rightCard.png");
        rightCard.setIcon(rightIcon);
        add(rightCard);

        JButton adminBtn = new JButton();
        adminBtn.setBounds(50,400,79,29);
        ImageIcon adminIcon = new ImageIcon("Images/Login Menu/adminBtn.png");
        adminBtn.setIcon(adminIcon);
        rightCard.add(adminBtn);

        JButton sellerBtn = new JButton();
        sellerBtn.setBounds(190,400,79,29);
        ImageIcon sellerIcon = new ImageIcon("Images/Login Menu/sellerBtn.png");
        sellerBtn.setIcon(sellerIcon);
        rightCard.add(sellerBtn);

        JButton buyerBtn = new JButton();
        buyerBtn.setBounds(330,400,79,29);
        ImageIcon buyerIcon = new ImageIcon("Images/Login Menu/buyerBtn.png");
        buyerBtn.setIcon(buyerIcon);
        rightCard.add(buyerBtn);

        adminBtn.addActionListener( e -> {
            dispose();
            new LoginPage();
        });

        sellerBtn.addActionListener( e -> {
            dispose();
            new LoginPage();
        });

        buyerBtn.addActionListener( e -> {
            dispose();
            new LoginPage();
        });

        setVisible(true);
    }
}
