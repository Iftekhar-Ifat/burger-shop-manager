package Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class BuyerList extends JFrame {

    public BuyerList(){
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel background = new JLabel();
        background.setBounds(0,0,800,500);
        ImageIcon backImg = new ImageIcon("Images/Admin/Buyer List/background.png");
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

        /*Buyer List Table start*/

        JPanel buyerListTablePanel = new JPanel();
        buyerListTablePanel.setLayout(new BorderLayout());
        buyerListTablePanel.setBounds(26,79,600,370);
        buyerListTablePanel.setBackground(Color.white);
        background.add(buyerListTablePanel);

        Object[][] data = new Object[0][0];

        //Object[][] data = new Object[0][0];

        Object[] column = {"Name", "Mobile", "Status"};
        Font headerFont = new Font("Arial", Font.BOLD, 22);

        DefaultTableModel model = new DefaultTableModel(data,column);


        JTable buyerListTable = new JTable(model);
        buyerListTable.setFont(new Font("Arial", Font.PLAIN, 20));
        buyerListTable.setRowHeight(30);

/*
        center items start
*/
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0; x<column.length; x++){
            buyerListTable.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
/*
        center items end
*/

        JTableHeader tableHeader = buyerListTable.getTableHeader();
        tableHeader.setFont(headerFont);
        buyerListTablePanel.add(tableHeader, BorderLayout.NORTH);
        buyerListTablePanel.add(buyerListTable, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(buyerListTable);
        buyerListTablePanel.add(scrollPane);

/*
        Buyer List Table end
*/

        setVisible(true);
    }

}
