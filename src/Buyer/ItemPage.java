package Buyer;

import Authenticatio.LoginPage;
import Database.DataBase;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.SQLException;
import java.util.Arrays;


public class ItemPage extends JFrame {

    Color maroon = new Color(36,1,1);
    Color burgerColor = new Color(255,153,0);
    int[] sqlItemQuantity = new int[12];

    public ItemPage(){
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Burger Shop Manager");
        ImageIcon appIcon = new ImageIcon("Images/appIcon.png");
        this.setIconImage(appIcon.getImage());
        


        JLabel background = new JLabel();
        background.setBounds(0,0,800,500);
        background.setBackground(Color.WHITE);
        background.setOpaque(true);
        add(background);

        JButton sliderBack = new JButton();
        sliderBack.setBounds(12,233,30,35);
        sliderBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sliderBack.setBackground(Color.WHITE);
        sliderBack.setBorder(null);
        ImageIcon sliderBackIcon = new ImageIcon("Images/Buyer/Item Menu/backSlider.png");
        sliderBack.setIcon(sliderBackIcon);
        background.add(sliderBack);

        JButton sliderFront = new JButton();
        sliderFront.setBounds(610,233,30,35);
        sliderFront.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sliderFront.setBackground(Color.WHITE);
        sliderFront.setBorder(null);
        ImageIcon sliderFrontIcon = new ImageIcon("Images/Buyer/Item Menu/frontSlider.png");
        sliderFront.setIcon(sliderFrontIcon);
        background.add(sliderFront);

        JLabel receiptLabel = new JLabel();
        receiptLabel.setBounds(650,0,150,500);
        ImageIcon receiptImg = new ImageIcon("Images/Buyer/Item Menu/receiptLabel.png");
        receiptLabel.setIcon(receiptImg);
        background.add(receiptLabel);

        JButton orderBtn = new JButton();
        orderBtn.setBounds(17,426,115,50);
        orderBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon orderBtnImg = new ImageIcon("Images/Buyer/Item Menu/orderBtn.png");
        orderBtn.setIcon(orderBtnImg);
        receiptLabel.add(orderBtn);

        JLabel[] pageSlider = new JLabel[2];

        pageSlider[0] = new JLabel();
        pageSlider[0].setBounds(0,0,650,500);
        ImageIcon firstBackImg = new ImageIcon("Images/Buyer/Item Menu/firstBackground.png");
        pageSlider[0].setIcon(firstBackImg);
        background.add(pageSlider[0]);

        pageSlider[1] = new JLabel();
        pageSlider[1] .setBounds(0,0,650,500);
        ImageIcon secBackImg = new ImageIcon("Images/Buyer/Item Menu/secondBackground.png");
        pageSlider[1].setIcon(secBackImg);
        background.add(pageSlider[1]);

        /*Button ADD start*/
        JButton[] itemsName = new JButton[12];
        int xAxis = 50;
        for(int i=0; i<12; i++){
            itemsName[i] = new JButton();
            if(i==0 || i==1 || i==2 || i==6 || i==7 || i==8){
                itemsName[i].setBounds(xAxis,40,136,171);
                String path = "Images/Buyer/Item Menu/Items/" + (i+1) + ".png";
                itemsName[i].setBorder(null);
                itemsName[i].setBackground(null);
                itemsName[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                ImageIcon itemImg = new ImageIcon(path);
                itemsName[i].setIcon(itemImg);
                if(i==0 || i==1 || i==2){
                    pageSlider[0].add(itemsName[i]);
                }else{
                    pageSlider[1].add(itemsName[i]);
                }
            }else{
                itemsName[i].setBounds(xAxis,247,136,171);
                String path = "Images/Buyer/Item Menu/Items/" + (i+1) + ".png";
                itemsName[i].setBorder(null);
                itemsName[i].setBackground(null);
                itemsName[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                ImageIcon itemImg = new ImageIcon(path);
                itemsName[i].setIcon(itemImg);
                if(i==3 || i==4 || i==5){
                    pageSlider[0].add(itemsName[i]);
                }else{
                    pageSlider[1].add(itemsName[i]);
                }
            }
            if(xAxis < 450){
                xAxis += 200;
            }else{
                xAxis = 50;
            }
        }
        /*Button ADD end*/


        /*Slider action Start*/
        sliderBack.addActionListener( e -> {
            System.out.println();
            if(pageSlider[0].isVisible()){
                pageSlider[0].setVisible(false);
                pageSlider[1].setVisible(true);
            }else{
                pageSlider[1].setVisible(false);
                pageSlider[0].setVisible(true);
            }
        });

        sliderFront.addActionListener( e -> {
            if(pageSlider[0].isVisible()){
                pageSlider[0].setVisible(false);
                pageSlider[1].setVisible(true);
            }else{
                pageSlider[1].setVisible(false);
                pageSlider[0].setVisible(true);
            }
        });
        /*Slider action End*/

        /*Java er biroktikor Table start*/

        JPanel receiptTablePanel = new JPanel();
        receiptTablePanel.setLayout(new BorderLayout());
        receiptTablePanel.setBounds(5,65,140,350);
        receiptTablePanel.setBackground(Color.white);
        receiptLabel.add(receiptTablePanel);

        Object[][] data = new Object[0][0];

        Object[] column = {"Item No", "Qty.", "Price"};
        Font headerFont = new Font("Arial", Font.BOLD, 12);

        DefaultTableModel model = new DefaultTableModel(data,column);

        JTable receiptTable = new JTable(model);

            /*center items start*/
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int x=0; x<column.length; x++){
            receiptTable.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
            /*center items end*/

        JTableHeader tableHeader = receiptTable.getTableHeader();
        tableHeader.setFont(headerFont);
        receiptTablePanel.add(tableHeader, BorderLayout.NORTH);
        receiptTablePanel.add(receiptTable, BorderLayout.CENTER);

        int[] priceArray = {130, 120, 100, 90, 140, 115, 190, 150, 145, 80, 170, 200};
        Object[] selectedItem = new Object[3];



        for(int i=0; i<12; i++){
            int itemNo = i+1;
            int Price = priceArray[i];
            int finalI = i;
            itemsName[i].addActionListener(e -> {
                String Quantity = JOptionPane.showInputDialog(null,"Enter Quantity: ");
                selectedItem[0] = itemNo;
                selectedItem[1] = Integer.parseInt(Quantity);
                selectedItem[2] = Price*Integer.parseInt(Quantity);
                sqlItemQuantity[finalI] = Integer.parseInt(Quantity);
                model.addRow(selectedItem);
            });
        }

        /*Java er biroktikor Table end*/

        orderBtn.addActionListener( e -> {

            /*Insert Order into Database start*/
            String sqlQuery = "INSERT INTO `orders`(`Item-1`, `Item-2`, `Item-3`, `Item-4`, `Item-5`, `Item-6`, `Item-7`, `Item-8`, `Item-9`, `Item-10`, `Item-11`, `Item-12`) "
                    + "VALUES ('"+sqlItemQuantity[0]+"','"+sqlItemQuantity[1]+"','"+sqlItemQuantity[2]+"','"+sqlItemQuantity[3]+"','"+sqlItemQuantity[4]+"','"+sqlItemQuantity[5]+"','"+sqlItemQuantity[6]+"','"+sqlItemQuantity[7]+"','"+sqlItemQuantity[8]+"','"+sqlItemQuantity[9]+"','"+sqlItemQuantity[10]+"','"+sqlItemQuantity[11]+"')";

            DataBase db = new DataBase();
            try {
                db.Insert(sqlQuery);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            /*Insert Order into Database end*/

            dispose();
            new OrderConfirm();
        });

        setVisible(true);
    }
}
