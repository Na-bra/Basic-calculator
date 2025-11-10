package gui.button;


import java.awt.*;

public final class OperationButton extends Button {

    OperationButton() {
        super();
        getButtons();
        loadDesign();
    }

    @Override
    public void getButtons(){
        buttons.add(new ButtonEs("+"));
        buttons.add(new ButtonEs("-"));
        buttons.add(new ButtonEs("x"));
        buttons.add(new ButtonEs("/"));
        buttons.add(new ButtonEs("."));


    }

    @Override
    public void design(ButtonEs btn){
        // Operation buttons are highlighted in orange with dark text for contrast
        Color accent = new Color(0xFF8C00); // orange
        btn.setBackground(accent);
        btn.setForeground(Color.BLACK);
    }

}
