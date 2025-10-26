package gui.button;
import javax.swing.JButton;
import java.awt.Color;

public class ButtonEs extends JButton{

    public ButtonEs(String text){
        super(text);
        this.setFocusable(false);
        this.setFocusPainted(false);

        this.setBorder(null);
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
    }



}
