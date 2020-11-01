package com.airwallex.calculator;

import com.airwallex.calculator.core.Calculator;
import com.airwallex.calculator.exception.ApplicationException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.*;

/**
 * @author lezha13
 */
public class CommandTest {
    @Test
    public void testClear() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate("5 3 clear");
            assertTrue("stack should be empty", calculator.stackValues().size() == 0);

            // Multiline test
            calculator.calculate("5 3");
            calculator.calculate("clear");
            assertTrue("stack should be empty", calculator.stackValues().size() == 0);

        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void testUndo() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate("5 3 undo");
            List<BigDecimal> currentStackValues = calculator.stackValues();
            assertEquals("there is one number in the stack", 1, currentStackValues.size());
            assertEquals("the number should be 5", new BigDecimal(5.0), currentStackValues.get(0));

        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void testMultiUndo() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate("5 3 undo undo");
            List<BigDecimal> currentStackValues = calculator.stackValues();
            assertEquals("the stack should be empty", 0, currentStackValues.size());
        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }
}
