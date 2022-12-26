package org.example;

import java.util.Scanner;

import static org.example.Calculator.CALCULATOR;

public class Main {
    public static void main(String[] args) {
        Double sum = CALCULATOR.calculate(Operations.DIV, 0.0, 0.0);
        System.out.println(sum);
    }
}