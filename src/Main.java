import javax.swing.JFrame;

import gui.Panel;
import java.awt.*;

public class Main {

    JFrame window;
    public static void main(String [] args){
        Main main = new Main();
        main.go();
    }
    void go(){
        window = new JFrame("Calculator");
        Panel panel = new Panel();

        window.getContentPane().add(panel);
        window.setResizable(false);
        window.setVisible(true);
        window.setFocusable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}