package View;

//Andrey Navarro e Isaac Corrales

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    private JTextField display;



    private JButton[] numberButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, clrButton, delButton;

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

    // Getters and setters

    public JButton getDelButton() {
        return delButton;
    }

    public void setDelButton(JButton delButton) {
        this.delButton = delButton;
    }

    public JButton getClrButton() {
        return clrButton;
    }

    public void setClrButton(JButton clrButton) {
        this.clrButton = clrButton;
    }

    public JButton getEquButton() {
        return equButton;
    }

    public void setEquButton(JButton equButton) {
        this.equButton = equButton;
    }

    public JButton getDecButton() {
        return decButton;
    }

    public void setDecButton(JButton decButton) {
        this.decButton = decButton;
    }

    public JButton getDivButton() {
        return divButton;
    }

    public void setDivButton(JButton divButton) {
        this.divButton = divButton;
    }

    public JButton getMulButton() {
        return mulButton;
    }

    public void setMulButton(JButton mulButton) {
        this.mulButton = mulButton;
    }

    public JButton getSubButton() {
        return subButton;
    }

    public void setSubButton(JButton subButton) {
        this.subButton = subButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton[] getNumberButtons() {
        return numberButtons;
    }

    public void setNumberButtons(JButton[] numberButtons) {
        this.numberButtons = numberButtons;
    }

    public void setDisplay(JTextField display) {
        this.display = display;
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
