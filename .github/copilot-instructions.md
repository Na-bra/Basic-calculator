## Quick orientation — Basic-calculator

This repository is a small Java Swing calculator. The UI is hand-built (no build system) and evaluation logic is in `src/logic`. Use this file to help an AI agent become productive quickly.

Core files & responsibilities
- `src/Main.java` — application entry. Creates the JFrame, adds `gui.Panel`, calls `pack()` and shows the window.
- `src/gui/Panel.java` — top-level JPanel. Uses a null layout and absolute positions. It instantiates `ButtonManger` and `TextManger` and sets the preferred size via `boxSize`, `row`, and `column` fields.
- `src/gui/text/TextManger.java` — manages the single on-screen display `Text` (a JLabel). Uses a static `Text tx` and static `setText/getText` helpers. All UI updates are routed through `SwingUtilities.invokeLater`.
- `src/gui/button/*` — button model and concrete buttons:
  - `Button` (abstract) and `ButtonEs` (JButton subclass with common styling)
  - `NumberButton`, `OperationButton`, `CommandButton` populate grouped button lists and style them.
  - `ButtonManger` wires buttons into a `GridLayout` pad, maps indices manually (see `setIndex()`), and handles click events. It calls `TextManger.setText`/`getText`.
- `src/logic/Calculations.java` — parser/evaluator. Tokenizes an expression, runs * and / before + and -, and returns both numeric and string representations. Contains a custom `ZeroErrorException` for divide-by-zero.

Important architectural notes & patterns
- UI uses null layout + manual setBounds. Positioning is centralized in `Panel` and `TextManger`. Prefer editing only those files when changing layout.
- Buttons are created in groups (Number/Operation/Command) then assembled in `ButtonManger.setIndex()` into a HashMap keyed by display order. That mapping is manual and fragile — when adding/removing buttons update `setIndex()` and `loadTapPad()`.
- `TextManger` exposes a static API and a single shared `Text tx`. Other classes (e.g., `ButtonManger`) call `TextManger.setText(...)` directly. Treat `TextManger` as the UI display singleton.
- Thread-safety: all UI writes use Swing EDT via `SwingUtilities.invokeLater` in `TextManger`; other UI changes should follow the same pattern.

Integration & evaluation gotchas
- Operation symbol mismatch: `OperationButton` creates a multiply button labeled "x" while `Calculations.solveBODMAS` expects the `*` character. Expressions built from button text will contain `x` which the evaluator does not recognize. Map `'x' -> '*'` (or change the button label) before sending text to `Calculations`.
- The equals (`=`) command currently has no evaluation handler in `ButtonManger` (the code removes action listeners for several indices). The backspace `<-` button is wired manually at index 14. Search `ButtonManger.setIndex()` and `activateButtons()` when you need to change command behavior.
- `Calculations` tokenizer uses regex `(\d+(?:\.\d+)?|[+\-*/])` — it only supports digits, optional decimals and the operator set `+ - * /`. It does not support parentheses or negative-number unary operators.

Build / run (no build tool present)
From the project root (macOS / zsh), compile and run with the JDK. Use a sources file to avoid shell globbing issues:

```bash
find src -name "*.java" > sources.txt
javac -d out @sources.txt
java -cp out Main
```

Notes for editing and tests
- Small UI tweaks: edit layout sizes in `Panel.boxSize`, `row`, and `column` and in `TextManger` padding/font. Re-run the compile/run steps.
- When changing button text or order, update gui/button/ButtonManger.setIndex() to keep the display grid consistent.
- To add evaluation behavior, implement a handler for the `=` button in `ButtonManger.activateButtons()` that reads `TextManger.getText()`, normalizes symbols (e.g., `x -> *`), calls `new Calculations(expr)` and writes `TextManger.setText(result)`.

Search hints for humans/agents
- Look for UI wiring in `gui/Panel.java` and `gui/button/ButtonManger.java`.
- Evaluation logic lives in `src/logic/Calculations.java`.

If anything is missing or you want me to wire `=` and fix the `x`/`*` mismatch, tell me which behavior you prefer and I will apply a small, safe change and run a local compile to verify.
