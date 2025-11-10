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
        btn.setForeground(Color.GREEN.brighter());
    }

}
