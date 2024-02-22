package org.presentation.sda;

public class CalcApplication {
    private Calculator strategy;

    public void setCalculatorStrategy(Calculator strategy) {
        this.strategy = strategy;
    }

    public void calculate(String input) {
        if (strategy == null) {
            throw new IllegalStateException("Calculator strategy is not set.");
        }
        System.out.println(strategy.calculate(input));
    }

    public static void main(String[] args) {
        CalcApplication app = new CalcApplication();

        // Set the calculator strategy at runtime
        app.setCalculatorStrategy(new SimpleCalculator());

        // Call calculate method with input string
        app.calculate("2+3"); // Replace "input" with your actual input
    }
}
