package com.education.ztu;

import org.junit.*;
import org.junit.rules.*;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @BeforeClass
    public static void beforeAll() {
        System.out.println("Start CalculatorTest");
    }

    @AfterClass
    public static void afterAll() {
        System.out.println("End CalculatorTest");
    }

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testIsPositive() {
        assertTrue(calculator.isPositive(10));
        assertFalse(calculator.isPositive(-3));
    }

    @Test
    public void testDivideValid() {
        assertEquals(2, calculator.divide(10, 5));
    }

    @Test
    public void testDivideByZero() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Divider cannot be zero");
        calculator.divide(5, 0);
    }

    @Test
    @Ignore("Ignore example")
    public void ignoredTest() {
        fail("This test should be ignored");
    }
}
