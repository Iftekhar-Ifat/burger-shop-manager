package Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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

        /*Remove Seller Table start*/

        JPanel removeSellerTablePanel = new JPanel();
        removeSellerTablePanel.setLayout(new BorderLayout());
        removeSellerTablePanel.setBounds(26,71,600,295);
        removeSellerTablePanel.setBackground(Color.white);
        background.add(removeSellerTablePanel);

        Object[][] data = new Object[0][0];

        //Object[][] data = new Object[0][0];

        Object[] column = {"Name", "Mobile","E-mail"};
        Font headerFont = new Font("Arial", Font.BOLD, 22);

        DefaultTableModel model = new DefaultTableModel(data,column);


        JTable removeSellerTable = new JTable(model);
        removeSellerTable.setFont(new Font("Arial", Font.PLAIN, 20));
        removeSellerTable.setRowHeight(30);

/*
        center items start
*/
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0; x<column.length; x++){
            removeSellerTable.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
/*
        center items end
*/

        JTableHeader tableHeader = removeSellerTable.getTableHeader();
        tableHeader.setFont(headerFont);
        removeSellerTablePanel.add(tableHeader, BorderLayout.NORTH);
        removeSellerTablePanel.add(removeSellerTable, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(removeSellerTable);
        removeSellerTablePanel.add(scrollPane);

/*
        Remove Seller Table end
*/

        setVisible(true);
    }
}
