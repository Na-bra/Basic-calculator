package gui;

import button.ButtonManger;
import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    public int boxSize = 64;
    public int column = 10;
    public int row = 6;
    public int maxWidth = row * boxSize;
    public int maxHeight = column * boxSize;
    Text tx = new Text("|");
    ButtonManger bm;


    public Panel(){
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        bm = new ButtonManger(this);
        this.setPreferredSize(new Dimension(maxWidth, maxHeight));
        this.setDoubleBuffered(true);
    }

    public void displayText(Text text){
        int X_AXIS = 0;
        int Y_AXIS = maxHeight/4;
        text.setBounds(X_AXIS,Y_AXIS,maxWidth,(maxHeight)/2);
    }





}
