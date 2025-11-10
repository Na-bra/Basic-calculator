package gui.button;

import gui.Panel;
import gui.text.TextManger;
import logic.Calculations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * ButtonManger wires the calculator keypad. It keeps the visual order mapping
 * from the original project but fixes several bugs:
 * - replaces non-existent getFirst() calls
 * - makes backspace safe for empty text
 * - wires '=' to evaluate (normalizing 'x' -> '*')
 * - wires 'C' to clear
 */
public final class ButtonManger implements ActionListener {
    private final Panel panel;
    private final HashMap<Integer, JButton> hm = new HashMap<>(24, 0.75f);
    private final CommandButton cb;
    private final NumberButton nb;
    private final OperationButton ob;

    public ButtonManger(Panel panel) {
        this.panel = panel;
        cb = new CommandButton();
        nb = new NumberButton();
        ob = new OperationButton();
        setIndex();
        setButtonFonts();
        loadTapPad();
        activateButtons();
    }

    private void loadTapPad() {
        // keep a lightweight GridLayout pad and place it in the bottom half
        JPanel tapPad = new JPanel();
        tapPad.setLayout(new GridLayout(6, 3));
        panel.add(tapPad);

        tapPad.setBounds(0, panel.maxHeight / 2, panel.maxWidth, panel.maxHeight / 2);

        for (int i = 0; i < hm.size(); i++) {
            tapPad.add(hm.get(i));
        }
    }

    private void setIndex() {
        // Visual mapping (preserves original layout intent). Index comments show button meaning.
        hm.put(0, cb.buttons.get(2));   // C
        hm.put(1, ob.buttons.get(3));   // /
        hm.put(2, cb.buttons.get(0));   // =
        hm.put(3, nb.buttons.get(7));
        hm.put(4, nb.buttons.get(8));
        hm.put(5, nb.buttons.get(9));
        hm.put(6, nb.buttons.get(6));
        hm.put(7, nb.buttons.get(5));
        hm.put(8, nb.buttons.get(4));
        hm.put(9, nb.buttons.get(3));
        hm.put(10, nb.buttons.get(2));
        hm.put(11, nb.buttons.get(1));
        hm.put(12, ob.buttons.get(4));  // .
        hm.put(13, nb.buttons.get(0));
        hm.put(14, cb.buttons.get(1));  // <- backspace
        hm.put(15, ob.buttons.get(0));  // +
        hm.put(16, ob.buttons.get(1));  // -
        hm.put(17, ob.buttons.get(2));  // x
    }

    private void setButtonFonts() {
        Font buttonFont = new Font(Font.SANS_SERIF, Font.BOLD, 18);
        for (int i = 0; i < hm.size(); i++) {
            hm.get(i).setFont(buttonFont);
        }
    }

    private void activateButtons() {
        // Add the generic appending listener to non-command buttons
        for (int i = 0; i < hm.size(); i++) {
            JButton b = hm.get(i);
            String text = b.getText();
            if ("=".equals(text) || "C".equals(text) || "<-".equals(text)) {
                // command buttons handled below
                continue;
            }
            b.addActionListener(this);
        }

        // Clear button (C)
        JButton clearBtn = cb.buttons.get(2);
        clearBtn.addActionListener((ev) -> TextManger.clear());

        // Backspace button (<-)
        JButton backBtn = cb.buttons.get(1);
        backBtn.addActionListener((ev) -> {
            String str = TextManger.getText();
            if (str == null || str.isEmpty()) return;
            TextManger.setText(str.substring(0, Math.max(0, str.length() - 1)));
        });

        // Equals button (=) — evaluate safely, normalize 'x' -> '*'
        JButton equalsBtn = cb.buttons.get(0);
        equalsBtn.addActionListener((ev) -> {
            String expr = TextManger.getText();
            if (expr == null) return;
            expr = expr.replace('x', '*').replaceAll("\\s+", "");

            // remove trailing operators/dots
            while (!expr.isEmpty() && "+-*/.".indexOf(expr.charAt(expr.length() - 1)) != -1) {
                expr = expr.substring(0, expr.length() - 1);
            }
            if (expr.isEmpty()) return;

            try {
                Calculations calc = new Calculations(expr);
                TextManger.setText(calc.getStrSolution());
            } catch (Exception ex) {
                TextManger.setText("NaN");
                System.out.println("Evaluation error: " + ex.getMessage());
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src instanceof JButton) {
            JButton clickedButton = (JButton) src;
            String incText = clickedButton.getText();
            String previous = TextManger.getText();
            if (previous == null) previous = "";
            String newText = previous + incText;
            TextManger.setText(newText);
            // lightweight logging for debug
            System.out.println(newText);
        }
    }
}



