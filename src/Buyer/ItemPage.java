package Buyer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class ItemPage extends JFrame {

    Color maroon = new Color(36,1,1);
    Color burgerColor = new Color(255,153,0);

    public ItemPage(){
        setSize(816,538);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

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
        ImageIcon sliderBackIcon = new ImageIcon("Images/Item Menu/backSlider.png");
        sliderBack.setIcon(sliderBackIcon);
        background.add(sliderBack);

        JButton sliderFront = new JButton();
        sliderFront.setBounds(610,233,30,35);
        sliderFront.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sliderFront.setBackground(Color.WHITE);
        sliderFront.setBorder(null);
        ImageIcon sliderFrontIcon = new ImageIcon("Images/Item Menu/frontSlider.png");
        sliderFront.setIcon(sliderFrontIcon);
        background.add(sliderFront);

        JLabel receiptLabel = new JLabel();
        receiptLabel.setBounds(650,0,150,500);
        ImageIcon receiptImg = new ImageIcon("Images/Item Menu/receiptLabel.png");
        receiptLabel.setIcon(receiptImg);
        background.add(receiptLabel);

        JButton orderBtn = new JButton();
        orderBtn.setBounds(17,426,115,50);
        orderBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon orderBtnImg = new ImageIcon("Images/Item Menu/orderBtn.png");
        orderBtn.setIcon(orderBtnImg);
        receiptLabel.add(orderBtn);

        JLabel[] pageSlider = new JLabel[2];

        pageSlider[0] = new JLabel();
        pageSlider[0].setBounds(0,0,650,500);
        ImageIcon firstBackImg = new ImageIcon("Images/Item Menu/firstBackground.png");
        pageSlider[0].setIcon(firstBackImg);
        background.add(pageSlider[0]);

        pageSlider[1] = new JLabel();
        pageSlider[1] .setBounds(0,0,650,500);
        ImageIcon secBackImg = new ImageIcon("Images/Item Menu/secondBackground.png");
        pageSlider[1].setIcon(secBackImg);
        background.add(pageSlider[1]);

        /*Button ADD start*/
        JButton[] itemsName = new JButton[12];
        int xAxis = 50;
        for(int i=0; i<12; i++){
            itemsName[i] = new JButton();
            if(i==0 || i==1 || i==2 || i==6 || i==7 || i==8){
                itemsName[i].setBounds(xAxis,40,136,171);
                String path = "Images/Item Menu/Items/" + (i+1) + ".png";
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
                String path = "Images/Item Menu/Items/" + (i+1) + ".png";
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

        Object[][] data ={{"Item No","Qty.","Price"}};
        String[] column ={"Item No","Qty.","Price"};

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );

        DefaultTableModel model = new DefaultTableModel(data,column);

        JTable receiptTable = new JTable(model);

        for(int x=0; x<column.length; x++){
            receiptTable.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }

        receiptTable.setFont(new Font("Arial", Font.BOLD, 12));
        receiptTable.setBounds(5,65,140,350);
        receiptLabel.add(receiptTable);


        int[] priceArray = {130, 120, 100, 90, 140, 115, 190, 150, 145, 80, 170, 200};
        Object[] selectedItem = new Object[3];
        for(int i=0; i<12; i++){
            int itemNo = i+1;
            int Price = priceArray[i];
            itemsName[i].addActionListener( e -> {
                String Quantity = JOptionPane.showInputDialog(null,"Enter Quantity: ");
                selectedItem[0] = itemNo;
                selectedItem[1] = Integer.parseInt(Quantity);
                selectedItem[2] = Price*Integer.parseInt(Quantity);
                model.addRow(selectedItem);
            });
        }

        /*Java er biroktikor Table end*/

        orderBtn.addActionListener( e -> {
            dispose();
            new OrderConfirm();
        });

        setVisible(true);
    }
}
