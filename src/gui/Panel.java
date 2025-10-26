// java
package gui;

import gui.button.ButtonManger;
import gui.text.TextManger;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    public int boxSize = 64;
    public int column = 10;
    public int row = 6;
    public int maxWidth = row * boxSize;
    public int maxHeight = column * boxSize;
    //    Text tx = new Text("kbg,kbvkzdfbvkbv");
    ButtonManger bm;
    TextManger tm;

    public Panel() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        bm = new ButtonManger(this);
        this.setPreferredSize(new Dimension(maxWidth, maxHeight));
        tm = new TextManger(this);
//        displayText(tx);

//        this.setDoubleBuffered(true);
//    }

//    public void displayText(Text text){
//        final int X_AXIS = 0;
//        final int Y_AXIS = (maxHeight/4) ;
//        text.setBounds(X_AXIS, Y_AXIS, maxWidth, (maxHeight) / 2);
//
//        // Add the component once on the EDT
//        SwingUtilities.invokeLater(() -> {
//            if (text.getParent() == null) {
//                this.add(text);
//                this.revalidate();
//                this.repaint();
//            }
//        });
//
//        // Run the loop on a background thread to avoid blocking the EDT
//        Thread loopThread = new Thread(() -> {
//            while (!Thread.currentThread().isInterrupted()) {
//                // Any UI updates must be performed on the EDT
//                SwingUtilities.invokeLater(() -> {
//                    // If you need to update the text content or visuals, do it here.
//                    // Example: text.setText("..."); // depending on Text API
//                    text.repaint();
//                });
//
//                System.out.println("Functional");
//
//                try {
//                    Thread.sleep(500); // adjust sleep interval as needed
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        }, "Panel-DisplayText-Thread");
//
//        loopThread.setDaemon(true);
//        loopThread.start();
//    }
//
    }
}