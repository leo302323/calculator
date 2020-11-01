package com.airwallex.calculator.core;

import com.airwallex.calculator.command.CommandUtils;
import com.airwallex.calculator.exception.ApplicationException;
import com.airwallex.calculator.operator.Operator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author lezha13
 */
public class Calculator {
    private final Deque<BigDecimal> stack = new ArrayDeque<>();

    private final Deque<Operator> operatorHistory = new ArrayDeque<>();

    private static final String REGEX_PADDING_ZERO = "\\.*0*$";

    private Map<String, Integer> positionMap = new HashMap<>();

    private String input = "";

    public void calculate(String input) {
        try {
            this.input = input;
            this.positionMap = new HashMap<>();
            process(input.split(" "));
        } catch (ApplicationException e) {
            System.out.println(e.getMessage());
        } finally {
            printStack();
        }
    }

    public List<BigDecimal> stackValues() {
        List<BigDecimal> array = new ArrayList<>();
        stack.descendingIterator().forEachRemaining(array::add);
        return Collections.unmodifiableList(array);
    }

    public static String printValue(BigDecimal value) {
        return formatDecimal(value);
    }

    private void printStack() {
        System.out.print("Stack:");
        stack.descendingIterator().forEachRemaining(value -> {
            System.out.print(" ");
            System.out.print(printValue(value));
        });
        System.out.print("\n");
    }


    private static String formatDecimal (BigDecimal value){
        final DecimalFormat formater = new DecimalFormat();
        formater.setMaximumFractionDigits(10);
        formater.setGroupingSize(0);
        formater.setRoundingMode(RoundingMode.FLOOR);
        String result = formater.format(value);
        return result;
    }

    private void process(String... tokens) throws ApplicationException {
        for (String token : tokens) {
            try {
                invokeCommand(token);
                positionMap.put(token, getPosition(token));
            } catch (ApplicationException exception) {
                int position = getPosition(token);
                throw new ApplicationException(token, position + 1, exception.getMessage());
            }
        }
    }

    private int getPosition(String token) {
        if(positionMap.get(token) != null) {
            return this.input.indexOf(token, positionMap.get(token) + 1);
        }

        return this.input.indexOf(token);
    }

    private void invokeCommand(String token) throws ApplicationException {
        if (CommandUtils.SUPPORTED_OPERATIONS.get(token) != null) {
            CommandUtils.SUPPORTED_OPERATIONS.get(token).invoke(stack, operatorHistory, null);
        } else {
            try {
                BigDecimal value = new BigDecimal(token);
                CommandUtils.INPUT.invoke(stack, operatorHistory, value);
            } catch (NumberFormatException e) {
                throw new ApplicationException("invalid input");
            }
        }
    }
}
