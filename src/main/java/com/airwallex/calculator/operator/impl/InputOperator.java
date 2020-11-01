package com.airwallex.calculator.operator.impl;

import com.airwallex.calculator.exception.ApplicationException;
import com.airwallex.calculator.operator.Operator;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.List;

/**
 * @author lezha13
 */
public class InputOperator extends AbstractOperator implements Operator {

    public InputOperator(List<BigDecimal> data) {
        super(data);
    }

    @Override
    public void invoke(Deque<BigDecimal> stack, Deque<Operator> operatorHistory) throws ApplicationException {
        inputStack(stack);
        operatorHistory.push(this);
    }

    @Override
    public void undo(Deque<BigDecimal> stack) {
        stack.pop();
    }
}
