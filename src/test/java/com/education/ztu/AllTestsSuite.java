package com.education.ztu;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculatorTest.class,
        CalculatorParamsTest.class,
        MessagePrinterTest.class,
        MessagePrinterSpyTest.class
})
public class AllTestsSuite {
}
