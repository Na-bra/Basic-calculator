package gui.button;
import javax.swing.JButton;
import java.awt.Color;

public class ButtonEs extends JButton{

    public ButtonEs(String text){
        super(text);
        this.setFocusable(false);
        this.setFocusPainted(false);

        // Lightweight, flat button styling. Keep background default black-ish
        this.setBorder(null);
        this.setBorderPainted(false);
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setDoubleBuffered(true);
    }



}
