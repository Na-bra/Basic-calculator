package gui.button;

import java.awt.*;

public final class CommandButton extends Button {

    public CommandButton (){
        super();
        getButtons();
        loadDesign();
    }
    @Override
    public void getButtons() {
        buttons.add(new ButtonEs("="));
        buttons.add(new ButtonEs("<-"));
        buttons.add(new ButtonEs("C"));

    }
    @Override
    public void design(ButtonEs btn){
        // Command buttons use white background with dark text for clarity
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
    }
}
