import javax.swing.*;
import java.awt.*;


public class ItemPage extends JFrame {

    Color maroon = new Color(36,1,1);
    Color burgerColor = new Color(255,153,0);

    ItemPage(){
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
        ImageIcon sliderBackIcon = new ImageIcon("Images/Item Menu One/backSlider.png");
        sliderBack.setIcon(sliderBackIcon);
        background.add(sliderBack);

        JButton sliderFront = new JButton();
        sliderFront.setBounds(610,233,30,35);
        sliderFront.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sliderFront.setBackground(Color.WHITE);
        sliderFront.setBorder(null);
        ImageIcon sliderFrontIcon = new ImageIcon("Images/Item Menu One/frontSlider.png");
        sliderFront.setIcon(sliderFrontIcon);
        background.add(sliderFront);

        JLabel receiptLabel = new JLabel();
        receiptLabel.setBounds(650,0,150,500);
        ImageIcon receiptImg = new ImageIcon("Images/Item Menu One/receiptLabel.png");
        receiptLabel.setIcon(receiptImg);
        background.add(receiptLabel);

        JButton orderBtn = new JButton();
        orderBtn.setBounds(17,426,115,50);
        orderBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon orderBtnImg = new ImageIcon("Images/Item Menu One/orderBtn.png");
        orderBtn.setIcon(orderBtnImg);
        receiptLabel.add(orderBtn);



        JLabel[] pageSlider = new JLabel[2];

        pageSlider[0] = new JLabel();
        pageSlider[0].setBounds(0,0,650,500);
        ImageIcon firstBackImg = new ImageIcon("Images/Item Menu One/firstBackground.png");
        pageSlider[0].setIcon(firstBackImg);
        background.add(pageSlider[0]);

        pageSlider[1] = new JLabel();
        pageSlider[1] .setBounds(0,0,650,500);
        ImageIcon secBackImg = new ImageIcon("Images/Item Menu One/secondBackground.png");
        pageSlider[1].setIcon(secBackImg);
        background.add(pageSlider[1]);


        JButton[] itemsName = new JButton[12];

        int xAxis = 50;

        for(int i=0; i<12; i++){
            itemsName[i] = new JButton();
            if(i==0 || i==1 || i==2 || i==6 || i==7 || i==8){
                itemsName[i].setBounds(xAxis,40,136,171);
                String path = "Images/Item Menu One/Items/" + (i+1) + ".png";
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
                if(xAxis < 450){
                    xAxis += 200;
                }else{
                    xAxis = 50;
                }
            }else{
                itemsName[i].setBounds(xAxis,247,136,171);
                String path = "Images/Item Menu One/Items/" + (i+1) + ".png";
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
                if(xAxis < 450){
                    xAxis += 200;
                }else{
                    xAxis = 50;
                }
            }

        }



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



        setVisible(true);
    }
}
