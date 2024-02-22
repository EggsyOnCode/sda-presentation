package org.presentation.sda;

public abstract class Calculator<T> {
    // Abstract method signatures
    public abstract T add(T a, T b);
    public abstract T subtract(T a, T b);
    public abstract T multiply(T a, T b);
    public abstract T divide(T a, T b);

    // Public method to intelligently calculate based on operator
    public abstract T calculate(String input);

    // Abstract method to convert string to number
    protected abstract T convertToNumber(String input);
}
