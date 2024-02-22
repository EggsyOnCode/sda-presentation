package org.presentation.sda;

public class GraphingCalculator extends Calculator<Double> {

    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double subtract(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double multiply(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double divide(Double a, Double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Division by zero error");
        }
    }

    @Override
    public Double calculate(String input) {
        System.out.println("This is a graphic calculator.");
        return 0.0; // Dummy return value
    }

    @Override
    protected Double convertToNumber(String input) {
        return Double.parseDouble(input);
    }


}