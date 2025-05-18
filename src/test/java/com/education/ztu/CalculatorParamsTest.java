package com.education.ztu;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class CalculatorParamsTest {

    private final Calculator calculator = new Calculator();

    @Test
    @Parameters({
            "1, 2, 3",
            "0, 0, 0",
            "-1, -1, -2"
    })
    public void testAdd(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }
}
