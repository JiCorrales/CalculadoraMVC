package Controller;

import Model.CalculatorModel;
import View.CalculatorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import java.util.HashMap;
import java.util.Map;

public class CalculatorController implements ActionListener, MouseListener {
    private CalculatorModel model;
    private CalculatorView view;
    private Map<String, Runnable> actionsMap;

    // Constructor
    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        _init_();
        createActionsMap();
    }

    // Inicia el binding con la vista
    private void _init_() {
        // Register listeners for all number buttons
        for (int i = 0; i < 10; i++) {
            view.numberButtons[i].addActionListener(this);
            view.numberButtons[i].addMouseListener(this);
        }

        // Register listeners for operation buttons
        view.addButton.addActionListener(this);
        view.subButton.addActionListener(this);
        view.mulButton.addActionListener(this);
        view.divButton.addActionListener(this);
        view.decButton.addActionListener(this);
        view.equButton.addActionListener(this);
        view.clrButton.addActionListener(this);
        view.delButton.addActionListener(this);

        // Register mouse listeners for operation buttons
        view.addButton.addMouseListener(this);
        view.subButton.addMouseListener(this);
        view.mulButton.addMouseListener(this);
        view.divButton.addMouseListener(this);
        view.decButton.addMouseListener(this);
        view.equButton.addMouseListener(this);
        view.clrButton.addMouseListener(this);
        view.delButton.addMouseListener(this);
    }

    // Create a map to associate button texts with corresponding actions
    private void createActionsMap() {
        actionsMap = new HashMap<>();
        actionsMap.put("+", () -> operationButtonPressed("+"));
        actionsMap.put("-", () -> operationButtonPressed("-"));
        actionsMap.put("*", () -> operationButtonPressed("*"));
        actionsMap.put("/", () -> operationButtonPressed("/"));
        actionsMap.put(".", this::decimalButtonPressed);
        actionsMap.put("=", this::equalsButtonPressed);
        actionsMap.put("C", this::clearButtonPressed);
        actionsMap.put("DEL", this::deleteButtonPressed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String btnText = btn.getText();

        if (isNumber(btnText)) {
            numberButtonPressed(btnText);
        } else {
            Runnable action = actionsMap.get(btnText);
            if (action != null) {
                action.run();
            }
        }
    }

    private void numberButtonPressed(String number) {
        String currentDisplay = view.getDisplay();
        currentDisplay += number;
        view.setDisplay(currentDisplay);
        model.addNumber(number);
    }

    private void operationButtonPressed(String operation) {
        model.setOperation(operation);
        view.setDisplay("");
    }

    private void decimalButtonPressed() {
        String currentDisplay = view.getDisplay();
        if (!currentDisplay.contains(".")) {
            currentDisplay += ".";
            view.setDisplay(currentDisplay);
            model.addNumber(".");
        }
    }

    private void equalsButtonPressed() {
        model.calculate();
        view.setDisplay(model.getResult());
    }

    private void clearButtonPressed() {
        model.clear();
        view.setDisplay("");
    }

    private void deleteButtonPressed() {
        model.deleteLastInput();
        view.setDisplay(model.getCurrentNumber());
    }

    // Helper method to check if a string is a number
    boolean isNumber(String v) {
        try {
            Double.parseDouble(v);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void showView() {
        view.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println("Se presionó el botón " + btn.getText());
    }
    @Override
    public void mousePressed(MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println("Se presionó el botón " + btn.getText());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println("Se soltó el botón " + btn.getText());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println("Mouse sobre el botón " + btn.getText());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println("Mouse salió de sobre el botón " + btn.getText());
    }
}
