# Basic-calculator

A lightweight Java Swing calculator app. UI is hand-built (no build tool). Theme: black + orange + white.

Build & run (macOS / zsh)

Create a source list, compile, then run:

```bash
find src -name "*.java" > sources.txt
javac -d out @sources.txt
java -cp out Main
```

Project notes for contributors

- UI uses null layout with absolute bounds in `src/gui/Panel.java` and `src/gui/text/TextManger.java`.
- Buttons are grouped in `src/gui/button/*`. Visual order is assembled in `ButtonManger` and is manual — update `setIndex()` if you add/remove buttons.
- Evaluation logic lives in `src/logic/Calculations.java`. The tokenizer supports digits, decimals and operators + - * / only.
- Theme: main colors are black (background), orange (operation accents / border), and white (text and command buttons). See `src/gui/button/*` and `src/gui/text/TextManger.java`.

If you want the `=` button behavior changed (e.g., change the operation mapping or add parentheses support), open an issue or ask for a patch.

