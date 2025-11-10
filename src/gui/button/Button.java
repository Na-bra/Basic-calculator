package gui.button;

import java.util.ArrayList;

public abstract class Button{
    ArrayList<ButtonEs> buttons = new ArrayList<>();

    public void getButtons(){

    }

    public void design(ButtonEs btn) {

    }
    public void loadDesign(){
        for (ButtonEs button : buttons) {
            design(button);
        }
    }
}