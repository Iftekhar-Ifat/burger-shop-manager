package Admin;

import Database.DataBase;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class LiveSeller extends JFrame {

    public LiveSeller(){
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel background = new JLabel();
        background.setBounds(0,0,800,500);
        ImageIcon backImg = new ImageIcon("Images/Admin/Live Seller/background.png");
        background.setIcon(backImg);
        add(background);

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

        /*Live Seller Table start*/

        JPanel liveSellerTablePanel = new JPanel();
        liveSellerTablePanel.setLayout(new BorderLayout());
        liveSellerTablePanel.setBounds(26,79,600,370);
        liveSellerTablePanel.setBackground(Color.white);
        background.add(liveSellerTablePanel);

        Object[][] data = new Object[0][0];

        DataBase db = new DataBase();
        String dataQuery = "SELECT `Name`, `Mobile`, `UserStatus` FROM `registration` WHERE `UserStatus` = 'seller'";

        int tableRow = db.totalRow(dataQuery);
        Object[][] row = db.orderConfirm(dataQuery,tableRow,3);

        Object[] column = {"Name", "Mobile", "Status"};
        Font headerFont = new Font("Arial", Font.BOLD, 22);

        DefaultTableModel model = new DefaultTableModel(data,column);

        for (int j=0; j<tableRow; j++){
            model.addRow(row[j]);
        }

        JTable liveSellerTable = new JTable(model);
        liveSellerTable.setFont(new Font("Arial", Font.PLAIN, 15));
        liveSellerTable.setRowHeight(30);

        /*center items start*/
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0; x<column.length; x++){
            liveSellerTable.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
        /*center items end*/

        JTableHeader tableHeader = liveSellerTable.getTableHeader();
        tableHeader.setFont(headerFont);
        liveSellerTablePanel.add(tableHeader, BorderLayout.NORTH);
        liveSellerTablePanel.add(liveSellerTable, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(liveSellerTable);
        liveSellerTablePanel.add(scrollPane);

        /*Live Seller Table end*/
        setVisible(true);
    }
}
