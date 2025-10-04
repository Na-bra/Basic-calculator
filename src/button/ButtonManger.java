package button;
import gui.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ButtonManger{
    Panel panel;
    HashMap<Integer, JButton> hm = new HashMap<>(24,0.75f);
    CommandButton cb;
    NumberButton nb;
    OperationButton ob;
    int size;
    int x;
    int y;


    public ButtonManger(Panel panel){
        this.panel = panel;
        size = panel.boxSize;
        x = 0;
        y = panel.maxWidth/2;
        cb = new CommandButton();
        nb = new NumberButton();
        ob = new OperationButton();
        setIndex();
        setButtonFonts();
        loadTapPad();
    }

    public void loadTapPad(){
        int width = panel.maxWidth;
        int height = (panel.maxHeight)/2;
        JPanel tapPad = new JPanel();
        tapPad.setLayout(new GridLayout(6,3));
        panel.add(tapPad);

        tapPad.setBounds(width - panel.maxWidth,panel.maxHeight - height - 100,width,height + 100);

        for (int i = 0; i < hm.size(); i++){
            tapPad.add(hm.get(i));
        }
    }

    public void setIndex(){
        hm.put(0,cb.buttons.get(2));
        hm.put(1, ob.buttons.get(3));
        hm.put(2,cb.buttons.getFirst());
        hm.put(3,nb.buttons.get(7));
        hm.put(4,nb.buttons.get(8));
        hm.put(5,nb.buttons.get(9));
        hm.put(6,nb.buttons.get(6));
        hm.put(7,nb.buttons.get(5));
        hm.put(8,nb.buttons.get(4));
        hm.put(9,nb.buttons.get(3));
        hm.put(10,nb.buttons.get(2));
        hm.put(11,nb.buttons.get(1));
        hm.put(12,ob.buttons.get(4));
        hm.put(13,nb.buttons.get(0));
        hm.put(14,cb.buttons.get(1));
        hm.put(15,ob.buttons.getFirst());
        hm.put(16,ob.buttons.get(1));
        hm.put(17,ob.buttons.get(2));

    }




    public void setButtonFonts(){
        Font buttonFont = new Font(Font.SANS_SERIF, Font.BOLD,18);
        for (int i = 0; i < hm.size(); i++){
            hm.get(i).setFont(buttonFont);
        }
    }
}


