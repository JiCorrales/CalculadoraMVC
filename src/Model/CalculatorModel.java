package Model;

public class CalculatorModel {
    private double result;
    private String currentNumber;
    private String currentOperation;

    public CalculatorModel() {
        clear();
    }

    // Clear all values
    public void clear() {
        result = 0;
        currentNumber = "";
        currentOperation = "";
    }

    // Delete last input
    public void deleteLastInput() {
        if (!currentNumber.isEmpty()) {
            // Remove the last character from the current number
            currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
        }
    }

    // Add a number to the current input
    public void addNumber(String number) {
//        System.out.println("Adding number: " + number);
        currentNumber += number;
//        System.out.println("Current number: " + currentNumber);

    }

    // Set the operation to be performed
    public void setOperation(String operation) {
        if (!currentOperation.isEmpty()) {
            calculate();
        } else {
            result = Double.parseDouble(currentNumber);
        }
        currentOperation = operation;
        currentNumber = "";
    }

    // Calculate the result based on the current operation
    public void calculate() {
        double number = currentNumber.isEmpty() ? 0 : Double.parseDouble(currentNumber);
        switch (currentOperation) {
            case "+":
                result += number;
                break;
            case "-":
                result -= number;
                break;
            case "*":
                result *= number;
                break;
            case "/":
                if (number != 0) {
                    result /= number;
                } else {
                    result = Double.NaN; // handle division by zero
                }
                break;
        }
        currentOperation = "";
        currentNumber = String.valueOf(result);
    }
    private boolean isValidExpression(){
        return !currentNumber.isEmpty() && !currentOperation.isEmpty();
    }
    // Get the current result
    public String getResult() {
        return currentNumber;
    }

    // Get the current number
    public String getCurrentNumber() {
        return currentNumber;
    }
    public String getCurrentOperation() {
        return currentOperation;
    }

}

