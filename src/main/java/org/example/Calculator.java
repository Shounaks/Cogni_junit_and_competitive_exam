package org.example;

public class Calculator {
    private Calculator() {}

    public static final Calculator CALCULATOR = new Calculator();


    public final Double calculate(Operations operation,Double num1,Double num2) {
        double result = operation.getOperation().applyAsDouble(num1, num2);
        if (Double.isInfinite(result)){throw new ArithmeticException("Positive/Negative Infinity Occurred: Calculator doesn't support such numbers");}
        if (Double.isNaN(result)){throw new ArithmeticException("Result is NaN: Calculator doesn't support such numbers");}
        return result;
    }
}

