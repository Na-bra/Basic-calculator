package button;

import javax.swing.*;
import java.awt.*;

public class NumberButton extends Button{

    NumberButton() {
        super();
        this.getButtons();
        this.loadDesign();

    }

    @Override
    public void getButtons() {
        buttons.add(new ButtonEs("0"));
        buttons.add(new ButtonEs("1"));
        buttons.add(new ButtonEs("2"));
        buttons.add(new ButtonEs("3"));
        buttons.add(new ButtonEs("4"));
        buttons.add(new ButtonEs("5"));
        buttons.add(new ButtonEs("6"));
        buttons.add(new ButtonEs("7"));
        buttons.add(new ButtonEs("8"));
        buttons.add(new ButtonEs("9"));

    }
    @Override
    public void design(ButtonEs btn){
        btn.setForeground(Color.white);

    }

}
