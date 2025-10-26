// java
package gui.text;

import gui.Panel;

import javax.swing.*;
import java.awt.*;

public class TextManger {
    private final static String BASIC = "0";
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
        tx.setForeground(Color.WHITE);
        tx.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 36));
        tx.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(tx);
    }

    public static void setText(String text) {
        displayedText = text;
        SwingUtilities.invokeLater(() -> tx.setText(displayedText));
    }

    public static String getText() {
        return tx.getText();
    }




}
