package Seller;
import Database.DataBase;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConfirmOrder extends JFrame {
    Color maroon = new Color(36,1,1);
    Color burgerColor = new Color(255,153,0);
    public ConfirmOrder(){
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel background = new JLabel();
        background.setBounds(0,0,800,500);
        ImageIcon backImg = new ImageIcon("Images/Seller/Order Confirm/background.png");
        background.setIcon(backImg);
        add(background);

        JButton backBtn = new JButton();
        backBtn.setBounds(11, 10, 115,50);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon backIcon = new ImageIcon("Images/Buyer/Order Confirm/backBtn.png");
        backBtn.setIcon(backIcon);
        background.add(backBtn);

        JButton confirmBtn = new JButton();
        confirmBtn.setBounds(146, 426, 90,30);
        confirmBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon confirmIcon = new ImageIcon("Images/Seller/Order Confirm/confirmBtn.png");
        confirmBtn.setIcon(confirmIcon);
        background.add(confirmBtn);

        JButton checkBtn = new JButton();
        checkBtn.setBounds(446, 426, 90,30);
        checkBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon checkIcon = new ImageIcon("Images/Seller/Order Confirm/checkBtn.png");
        checkBtn.setIcon(checkIcon);
        background.add(checkBtn);

        JTextField customerIdField = new JTextField();
        customerIdField.setBounds(201,347,70,25);
        customerIdField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        customerIdField.setFont(new Font("Arial", Font.BOLD, 18));
        customerIdField.setForeground(burgerColor);
        customerIdField.setCaretColor(burgerColor);
        customerIdField.setBackground(maroon);
        background.add(customerIdField);

        JTextField confirmItemNoField = new JTextField();
        confirmItemNoField.setBounds(201,382,70,25);
        confirmItemNoField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        confirmItemNoField.setFont(new Font("Arial", Font.BOLD, 18));
        confirmItemNoField.setForeground(burgerColor);
        confirmItemNoField.setCaretColor(burgerColor);
        confirmItemNoField.setBackground(maroon);
        background.add(confirmItemNoField);

        JTextField checkItemNoField = new JTextField();
        checkItemNoField.setBounds(498,347,70,25);
        checkItemNoField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        checkItemNoField.setFont(new Font("Arial", Font.BOLD, 18));
        checkItemNoField.setForeground(burgerColor);
        checkItemNoField.setCaretColor(burgerColor);
        checkItemNoField.setBackground(maroon);
        background.add(checkItemNoField);

        JLabel totalLabel = new JLabel("0",SwingConstants.CENTER);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
        totalLabel.setBackground(maroon);
        totalLabel.setForeground(burgerColor);
        totalLabel.setBounds(498,382,70,25);
        totalLabel.setOpaque(true);
        background.add(totalLabel);

        /*Confirm Order Table start*/

        JPanel confirmOrderTablePanel = new JPanel();
        confirmOrderTablePanel.setLayout(new BorderLayout());
        confirmOrderTablePanel.setBounds(39,76,574,219);
        confirmOrderTablePanel.setBackground(Color.white);
        background.add(confirmOrderTablePanel);

        /* SQL queries for table start*/
        Object[][] data = new Object[0][0];

        DataBase db = new DataBase();
        String dataQuery = "SELECT * FROM `orders`";

        int tableRow = db.totalRow(dataQuery);
        Object[][] row = db.orderConfirm(dataQuery,tableRow,13);

        /* SQL queries for table end*/

        Object[] column = {"C_ID","Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "Item 11", "Item 12"};
        Font headerFont = new Font("Arial", Font.BOLD, 11);

        DefaultTableModel model = new DefaultTableModel(data,column);

        for (int j=0; j<tableRow; j++){
            model.addRow(row[j]);
        }


        JTable confirmOrderTable = new JTable(model);
        confirmOrderTable.setFont(new Font("Arial", Font.PLAIN, 11));
        confirmOrderTable.setRowHeight(20);

/*
        center items start
*/
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0; x<column.length; x++){
            confirmOrderTable.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
/*
        center items end
*/

        JTableHeader tableHeader = confirmOrderTable.getTableHeader();
        tableHeader.setFont(headerFont);
        confirmOrderTablePanel.add(tableHeader, BorderLayout.NORTH);
        confirmOrderTablePanel.add(confirmOrderTable, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(confirmOrderTable);
        confirmOrderTablePanel.add(scrollPane);

/*
        Confirm Order Table end
*/

        backBtn.addActionListener(e -> {
            dispose();
            new SellerDashboard();
        });

        confirmBtn.addActionListener(e -> {
            String customerId = customerIdField.getText();
            String itemNo = "Item-"+confirmItemNoField.getText();
            JOptionPane.showMessageDialog(null,"Customer "+customerId+"'s Item No: "+itemNo+" is confirmed!");
            String customerOrderQueryUpdate = "UPDATE `orders` SET `"+itemNo+"`=0 "+"WHERE `C_ID`="+customerId;
            String deleteEmptyRow = "DELETE FROM `orders` WHERE `Item-1` = 0 AND`Item-2` = 0 AND `Item-3` = 0 AND `Item-4` = 0 AND `Item-5` = 0 AND `Item-6`" +
                    " = 0 AND `Item-7` = 0 AND `Item-8` = 0 AND `Item-9` = 0 AND `Item-10` = 0 AND `Item-11` = 0 AND `Item-12` = 0 ";
            db.updateTable(customerOrderQueryUpdate);
            db.deleteRow(deleteEmptyRow);
            dispose();
            new ConfirmOrder();

        });

        checkBtn.addActionListener(e -> {
            String item = checkItemNoField.getText();
            String addItemQuery = "SELECT `Quantity` FROM `burger_items` WHERE `Item No.` = "+item;
            String totalItem = db.totalItem(addItemQuery);
            totalLabel.setText(totalItem);
        });


        setVisible(true);
    }
}
