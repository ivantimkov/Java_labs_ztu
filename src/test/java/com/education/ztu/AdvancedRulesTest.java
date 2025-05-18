package com.education.ztu;

import org.junit.*;
import org.junit.rules.*;
import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class AdvancedRulesTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Rule
    public TestName testName = new TestName();

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Rule
    public Verifier verifier = new Verifier() {
        @Override
        protected void verify() throws Throwable {
            assertNotNull("Calculator should not be null after test", calculator);
        }
    };

    @Rule
    public Timeout timeout = Timeout.millis(500);

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Running test: " + testName.getMethodName());
    }

    @Test
    public void testTemporaryFolderCreation() throws IOException {
        File file = tempFolder.newFile("test.txt");
        assertTrue(file.exists());
    }

    @Test
    public void testErrorCollector() {
        collector.addError(new Throwable("First error"));
        collector.addError(new Throwable("Second error"));

        collector.checkThat("Hello", containsString("Hello"));  // Ця перевірка пройде
    }

    @Test
    public void testVerifierRule() {
        assertNotNull(calculator);
    }
}
