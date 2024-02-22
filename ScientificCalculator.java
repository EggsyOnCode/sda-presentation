package org.presentation.sda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScientificCalculator extends Calculator<Float> {

    @Override
    public Float add(Float a, Float b) {
        return a + b;
    }

    @Override
    public Float subtract(Float a, Float b) {
        return a - b;
    }

    @Override
    public Float multiply(Float a, Float b) {
        return a * b;
    }

    @Override
    public Float divide(Float a, Float b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Division by zero error");
        }
    }

    @Override
    public Float calculate(String input) {
        // Use regex to extract operator and numbers
        Pattern pattern = Pattern.compile("([\\d.]+)\\s*([+\\-*/])\\s*([\\d.]+)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            Float a = convertToNumber(matcher.group(1));
            Float b = convertToNumber(matcher.group(3));
            String operator = matcher.group(2);

            switch (operator) {
                case "+":
                    return add(a, b);
                case "-":
                    return subtract(a, b);
                case "*":
                    return multiply(a, b);
                case "/":
                    return divide(a, b);
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        } else {
            throw new IllegalArgumentException("Invalid input format: " + input);
        }
    }

    @Override
    protected Float convertToNumber(String input) {
        return Float.parseFloat(input);
    }
}
