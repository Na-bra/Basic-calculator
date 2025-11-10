// java
package gui.text;

import gui.Panel;

import javax.swing.*;
import java.awt.*;

public class TextManger {
    private final static String BASIC = "";
    private static Text tx = new Text(BASIC);
    private static String displayedText;
    Panel panel;

    public TextManger(Panel panel){
        this.panel = panel;

        // position and style the display label (using null layout from Panel)
        int padding = 10;
        int width = panel.maxWidth - padding * 2;
        int height = panel.maxHeight / 4;
        tx.setBounds(padding, padding, width, height - padding);
        // Display styling: keep text white on black with an orange border accent
        tx.setOpaque(true);
        tx.setBackground(Color.BLACK);
        tx.setForeground(Color.WHITE);
        tx.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 36));
        tx.setHorizontalAlignment(SwingConstants.RIGHT);
        tx.setBorder(BorderFactory.createLineBorder(new Color(0xFF8C00), 2));
        panel.add(tx);
    }

    public static void setText(String text) {
        displayedText = text;
        SwingUtilities.invokeLater(() -> tx.setText(displayedText));
    }

    public static String getText() {
        return tx.getText();
    }

    public static void clear(){
        tx.setText("");
    }




}
