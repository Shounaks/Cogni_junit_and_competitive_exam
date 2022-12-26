package org.example;

import java.util.function.DoubleBinaryOperator;

public enum Operations {
    ADD(Double::sum),
    SUB((x, y) -> x - y),
    MUL((x, y) -> x * y),
    DIV((x, y) -> x / y);

    private final DoubleBinaryOperator operation;

    private Operations(DoubleBinaryOperator operation) {
        this.operation = operation;
    }

    public DoubleBinaryOperator getOperation() {
        return operation;
    }
}
