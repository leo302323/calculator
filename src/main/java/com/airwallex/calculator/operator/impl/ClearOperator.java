package com.airwallex.calculator.operator.impl;

import com.airwallex.calculator.exception.ApplicationException;
import com.airwallex.calculator.operator.Operator;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Deque;

/**
 * @author lezha13
 */
public class ClearOperator extends AbstractOperator implements Operator {
    public ClearOperator() {
        super(Collections.emptyList());
    }

    @Override
    public void invoke(Deque<BigDecimal> stack, Deque<Operator> operatorHistory) throws ApplicationException {
        stack.clear();
        operatorHistory.clear();
    }

    @Override
    public void undo(Deque<BigDecimal> stack) {

    }
}
