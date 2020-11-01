package com.airwallex.calculator;

import com.airwallex.calculator.core.Calculator;
import com.airwallex.calculator.exception.ApplicationException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.fail;

/**
 * @author lezha13
 */
public class ExampleTest {
    @Test
    public void example1Test() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate("5 2");
            String result = convertStackResultToString(calculator.stackValues());

            assertEquals("stack is ", "5 2", result);

        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void example2Test() {
        try {
            Calculator calculator = new Calculator();

            calculator.calculate("2 sqrt");
            String result = convertStackResultToString(calculator.stackValues());
            assertEquals("stack is ", "1.4142135623", result);

            calculator.calculate("clear 9 sqrt");
            result = convertStackResultToString(calculator.stackValues());
            assertEquals("stack is ", "3", result);

        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void example3Test() {
        try {
            Calculator calculator = new Calculator();
            calculator.calculate("5 2 -");
            assertEquals("stack is ", "3", convertStackResultToString(calculator.stackValues()));

            calculator.calculate("3 -");
            assertEquals("stack is ", "0", convertStackResultToString(calculator.stackValues()));

            calculator.calculate("clear");
            assertEquals("stack is ", "", convertStackResultToString(calculator.stackValues()));
        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void example4Test() {
        try {
            Calculator calculator = new Calculator();
            calculator.calculate("5 4 3 2");
            assertEquals("stack is ", "5 4 3 2", convertStackResultToString(calculator.stackValues()));

            calculator.calculate("undo undo *");
            assertEquals("stack is ", "20", convertStackResultToString(calculator.stackValues()));

            calculator.calculate("5 *");
            assertEquals("stack is ", "100", convertStackResultToString(calculator.stackValues()));

            calculator.calculate("undo");
            assertEquals("stack is ", "20 5", convertStackResultToString(calculator.stackValues()));
        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void example5Test() {
        try {
            Calculator calculator = new Calculator();

            calculator.calculate("7 12 2 /");
            assertEquals("stack is ", "7 6", convertStackResultToString(calculator.stackValues()));

            calculator.calculate("*");
            assertEquals("stack is ", "42", convertStackResultToString(calculator.stackValues()));

            calculator.calculate("4 /");
            assertEquals("stack is ", "10.5", convertStackResultToString(calculator.stackValues()));
        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void example6Test() {
        try {
            Calculator calculator = new Calculator();

            calculator.calculate("1 2 3 4 5");
            assertEquals("stack is ", "1 2 3 4 5", convertStackResultToString(calculator.stackValues()));

            calculator.calculate("*");
            assertEquals("stack is ", "1 2 3 20", convertStackResultToString(calculator.stackValues()));

            calculator.calculate("clear 3 4 -");
            assertEquals("stack is ", "-1", convertStackResultToString(calculator.stackValues()));
        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void example7Test() {
        try {
            Calculator calculator = new Calculator();

            calculator.calculate("1 2 3 4 5");
            assertEquals("stack is ", "1 2 3 4 5", convertStackResultToString(calculator.stackValues()));


            calculator.calculate("* * * *");
            assertEquals("stack is ", "120", convertStackResultToString(calculator.stackValues()));

        } catch (ApplicationException e) {
            fail("Shouldn't be here.");
        }
    }

    @Test
    public void example8Test() {
        try {
            Calculator calculator = new Calculator();
            calculator.calculate("1 2 3 * 5 + * * 6 5 ");
        } catch (ApplicationException e) {
            assertEquals("exception message is", "operator * (position: 15): insufficient parameters", e.getMessage());
        }
    }

    private String convertStackResultToString(List<BigDecimal> stackResult) {
        return stackResult.stream()
                .map(Calculator::printValue).collect(Collectors.joining(" "));
    }
}
