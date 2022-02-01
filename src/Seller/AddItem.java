package Seller;

import Database.DataBase;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class AddItem extends JFrame {
    Color maroon = new Color(36,1,1);
    Color burgerColor = new Color(255,153,0);

    public AddItem(){
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Burger Shop Manager");
        ImageIcon appIcon = new ImageIcon("Images/appIcon.png");
        this.setIconImage(appIcon.getImage());
        


        JLabel background = new JLabel();
        background.setBounds(0,0,800,500);
        ImageIcon backImg = new ImageIcon("Images/Seller/Add Item/background.png");
        background.setIcon(backImg);
        add(background);

        JButton backBtn = new JButton();
        backBtn.setBounds(11, 10, 115,50);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon backIcon = new ImageIcon("Images/Buyer/Order Confirm/backBtn.png");
        backBtn.setIcon(backIcon);
        background.add(backBtn);

        JButton storeBtn = new JButton();
        storeBtn.setBounds(199, 440, 100,40);
        storeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon storeIcon = new ImageIcon("Images/Seller/Add Item/storeBtn.png");
        storeBtn.setIcon(storeIcon);
        background.add(storeBtn);

        JButton refreshBtn = new JButton();
        refreshBtn.setBounds(350, 440, 100,40);
        refreshBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon refreshIcon = new ImageIcon("Images/Seller/Add Item/refreshBtn.png");
        refreshBtn.setIcon(refreshIcon);
        background.add(refreshBtn);

        JTextField itemNoField = new JTextField();
        itemNoField.setBounds(140,386,70,30);
        itemNoField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        itemNoField.setFont(new Font("Arial", Font.BOLD, 18));
        itemNoField.setForeground(burgerColor);
        itemNoField.setCaretColor(burgerColor);
        itemNoField.setBackground(maroon);
        background.add(itemNoField);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(329,386,70,30);
        quantityField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        quantityField.setFont(new Font("Arial", Font.BOLD, 18));
        quantityField.setForeground(burgerColor);
        quantityField.setCaretColor(burgerColor);
        quantityField.setBackground(maroon);
        background.add(quantityField);

        JTextField priceField = new JTextField();
        priceField.setBounds(534,386,70,30);
        priceField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        priceField.setFont(new Font("Arial", Font.BOLD, 18));
        priceField.setForeground(burgerColor);
        priceField.setCaretColor(burgerColor);
        priceField.setBackground(maroon);
        background.add(priceField);

        /*Add Item Table start*/

        JPanel confirmOrderTablePanel = new JPanel();
        confirmOrderTablePanel.setLayout(new BorderLayout());
        confirmOrderTablePanel.setBounds(30,78,590,295);
        confirmOrderTablePanel.setBackground(Color.white);
        background.add(confirmOrderTablePanel);

        /* SQL queries for table start*/
        Object[][] data = new Object[0][0];

        DataBase db = new DataBase();
        String dataQuery = "SELECT * FROM `burger_items`";

        int tableRow = db.totalRow(dataQuery);
        Object[][] row = db.orderConfirm(dataQuery,tableRow,4);

        /* SQL queries for table end*/


        Object[] column = {"Item No", "Item Name", "Quantity","Price"};
        Font headerFont = new Font("Arial", Font.BOLD, 22);

        DefaultTableModel model = new DefaultTableModel(data,column);

        for (int j=0; j<tableRow; j++){
            model.addRow(row[j]);
        }

        JTable addItemTable = new JTable(model);
        addItemTable.setFont(new Font("Arial", Font.PLAIN, 15));
        addItemTable.setRowHeight(22);



/*
        center items start
*/
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0; x<column.length; x++){
            addItemTable.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
/*
        center items end
*/

        JTableHeader tableHeader = addItemTable.getTableHeader();
        tableHeader.setFont(headerFont);
        confirmOrderTablePanel.add(tableHeader, BorderLayout.NORTH);
        confirmOrderTablePanel.add(addItemTable, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(addItemTable);
        confirmOrderTablePanel.add(scrollPane);

/*
        Add Item Table end
*/

        backBtn.addActionListener(e -> {
            dispose();
            new SellerDashboard();
        });

        storeBtn.addActionListener(e -> {
            String quantity = quantityField.getText();
            String item = itemNoField.getText();
            String addItemQuery = "UPDATE `burger_items` SET `Quantity`= "+quantity+" WHERE `Item No.` = "+item;
            db.updateTable(addItemQuery);
            dispose();
            new AddItem();
        });
        refreshBtn.addActionListener(e -> {
            dispose();
            new AddItem();
        });

        setVisible(true);
    }
}
