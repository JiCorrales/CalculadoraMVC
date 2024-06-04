package View;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    private JTextField display;
    public JButton[] numberButtons;
    public JButton addButton, subButton, mulButton, divButton;
    public JButton decButton, equButton, clrButton, delButton;

    public CalculatorView() {
        // Frame settings
        setTitle("Calculadora");
        setSize(420, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Display
        display = new JTextField();
        display.setBounds(50, 25, 300, 50);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 30));
        add(display);

        // Buttons
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 30));
            numberButtons[i].setFocusable(false);
        }

        // Reference to the buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        clrButton = new JButton("C");
        delButton = new JButton("DEL");

        // Array of function buttons
        JButton[] functionButtons = {addButton, subButton, mulButton, divButton, decButton, equButton, clrButton, delButton};

        // Set the font and focusable for the function buttons
        for (JButton btn : functionButtons) {
            btn.setFont(new Font("Arial", Font.PLAIN, 30));
            btn.setFocusable(false);
        }

        // Panel for number buttons and decimal
        JPanel panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        add(panel);

        clrButton.setBounds(50, 430, 145, 50);
        delButton.setBounds(205, 430, 145, 50);

        add(clrButton);
        add(delButton);
    }

    // Set the display value
    public void setDisplay(String value) {
        display.setText(value);
    }

    // Get the display value
    public String getDisplay() {
        return display.getText();
    }
}
