package gui.button;


import java.awt.*;

public class OperationButton extends Button {

    OperationButton() {
        super();
        getButtons();
        loadDesign();
    }

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
