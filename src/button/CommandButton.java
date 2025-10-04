package button;

import gui.Panel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CommandButton extends Button {

    public CommandButton (){
        super();
        getButtons();
        loadDesign();
    }
    public void getButtons() {
        buttons.add(new ButtonEs("="));
        buttons.add(new ButtonEs("<-"));
        buttons.add(new ButtonEs("C"));

    }
    @Override
    public void design(ButtonEs btn){
        btn.setForeground(Color.RED);
    }
}
