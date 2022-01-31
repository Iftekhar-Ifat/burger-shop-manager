package Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class ApproveSeller extends JFrame {
    public ApproveSeller(){
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel background = new JLabel();
        background.setBounds(0,0,800,500);
        ImageIcon backImg = new ImageIcon("Images/Admin/Approve Seller/background.png");
        background.setIcon(backImg);
        add(background);

        JButton backBtn = new JButton();
        backBtn.setBounds(11, 10, 115,50);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon backIcon = new ImageIcon("Images/Buyer/Order Confirm/backBtn.png");
        backBtn.setIcon(backIcon);
        background.add(backBtn);

        JButton approveBtn = new JButton();
        approveBtn.setBounds(295,422,115,50);
        approveBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon approveIcon = new ImageIcon("Images/Admin/Approve Seller/approveBtn.png");
        approveBtn.setIcon(approveIcon);
        background.add(approveBtn);


        /*Approve Seller Table start*/

        JPanel approveSellerTablePanel = new JPanel();
        approveSellerTablePanel.setLayout(new BorderLayout());
        approveSellerTablePanel.setBounds(26,71,600,340);
        approveSellerTablePanel.setBackground(Color.white);
        background.add(approveSellerTablePanel);

        Object[][] data = new Object[0][0];

        //Object[][] data = new Object[0][0];

        Object[] column = {"Name", "Mobile", "Status"};
        Font headerFont = new Font("Arial", Font.BOLD, 22);

        DefaultTableModel model = new DefaultTableModel(data,column);


        JTable approveSellerTable = new JTable(model);
        approveSellerTable.setFont(new Font("Arial", Font.PLAIN, 20));
        approveSellerTable.setRowHeight(30);

/*
        center items start
*/
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0; x<column.length; x++){
            approveSellerTable.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
/*
        center items end
*/

        JTableHeader tableHeader = approveSellerTable.getTableHeader();
        tableHeader.setFont(headerFont);
        approveSellerTablePanel.add(tableHeader, BorderLayout.NORTH);
        approveSellerTablePanel.add(approveSellerTable, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(approveSellerTable);
        approveSellerTablePanel.add(scrollPane);

/*
        Approve Seller Table end
*/


        backBtn.addActionListener( e -> {
            dispose();
            new Dashboard();
        });

        setVisible(true);
    }
}
