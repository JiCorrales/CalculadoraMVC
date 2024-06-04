package Controller;

import Model.CalculatorModel;
import View.CalculatorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.util.HashMap;



public class CalculatorController implements ActionListener {
    private final CalculatorModel model;
    private final CalculatorView view;
    private HashMap<String, Runnable> actionsMap;

    // Constructor
    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        _init_();
        createActionsMap();
    }

    // Start the binding with the view
    private void _init_() {
        // Register listeners for all number buttons
        for (int i = 0; i < 10; i++) {
            view.numberButtons[i].addActionListener(this);
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

    }

    /**
     *      So here we are creating a map of actions that will be executed when a button is pressed
     *      This is a way to avoid a long chain of if-else statements
     *      The key is the button text and the value is a Runnable that will be executed when the button is pressed
     *      So we think that this is a good way to handle the actions of the buttons
     *      Because we can easily add new actions, and we can easily see what action is executed when a button is pressed
     *      And it looks cleaner than a long chain of if-else statements
     */

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

    // Handle button clicks
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

    // Handle mouse events
    private void numberButtonPressed(String number) {
        String currentDisplay = view.getDisplay();
        currentDisplay += number;
        view.setDisplay(currentDisplay);
        model.addNumber(number);
    }
    // Handle mouse events
    private void operationButtonPressed(String operation) {
        model.setOperation(operation);
        view.setDisplay("");
    }
    // Handle mouse events
    private void decimalButtonPressed() {
        String currentDisplay = view.getDisplay();
        if (!currentDisplay.contains(".")) {
            currentDisplay += ".";
            view.setDisplay(currentDisplay);
            model.addNumber(".");
        }
    }
    // Handle mouse events
    private void equalsButtonPressed() {
        if (model.getCurrentOperation().isEmpty()) {
            return;
        }
        model.calculate();
        view.setDisplay(model.getResult());
    }
    // Handle mouse events
    private void clearButtonPressed() {
        model.clear();
        view.setDisplay("");
    }
    // Handle mouse events
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
    // Show the view
    public void showView() {
        view.setVisible(true);
    }

   
}
