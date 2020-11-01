package com.airwallex.calculator;

import com.airwallex.calculator.core.Calculator;
import com.airwallex.calculator.exception.ApplicationException;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.fail;

/**
 * @author lezha13
 */
public class CalculatorTest {
    @Test
    public void pushTest() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate("5 3");
            List<BigDecimal> values = calculator.stackValues();
            assertEquals("stack should have two numbers", 2, values.size());
            assertEquals("The first number should be 5", new BigDecimal(5.0), values.get(0));
            assertEquals("The second number should be 3", new BigDecimal(3.0), values.get(1));
        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate("1 2 + 3 4 + +");
            assertEquals("Value should be same",
                    "10", Calculator.printValue(calculator.stackValues().get(0)));
        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate("10 3 -");
            assertEquals("Value should be same",
                    "7", Calculator.printValue(calculator.stackValues().get(0)));
        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate("2 3 *");
            assertEquals("Value should be same",
                    "6", Calculator.printValue(calculator.stackValues().get(0)));
        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate("10 5 /");
            assertEquals("Value should be same",
                    "2", Calculator.printValue(calculator.stackValues().get(0)));
        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void testSqrt() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate("2 sqrt");
            assertEquals("Value should be same",
                    "1.4142135623", Calculator.printValue(calculator.stackValues().get(0)));
        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void testComplexCalculate() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate("1 3 + 1 - 2 * 3 / sqrt");
            assertEquals("Value should be same",
                    "1.4142135623", Calculator.printValue(calculator.stackValues().get(0)));
        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }
}
