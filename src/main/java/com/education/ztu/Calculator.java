package com.education.ztu;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return a / b;
    }

    public boolean isPositive(int number) {
        return number > 0;
    }
}
