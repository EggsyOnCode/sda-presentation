package org.presentation.sda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SimpleCalculator extends  Calculator<Integer>{

    @Override
    public Integer add(Integer a, Integer b) {
        return a+b;
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        return a-b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return a*b;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        if(b!=0){
            return a/b;
        }
        else{
            throw new Error("div by zero error");
        }
    }

    @Override
    public Integer calculate(String input) {
        // Use regex to extract operator and numbers
        Pattern pattern = Pattern.compile("([\\d.]+)\\s*([+\\-*/])\\s*([\\d.]+)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            Integer a = convertToNumber(matcher.group(1));
            Integer b = convertToNumber(matcher.group(3));
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
    protected Integer convertToNumber(String input) {
        return Integer.parseInt(input);
    }
}