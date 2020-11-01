package com.airwallex.calculator.operator.impl;

import com.airwallex.calculator.exception.ApplicationException;
import com.airwallex.calculator.operator.Operator;
import com.airwallex.calculator.operator.impl.AbstractOperator;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Deque;

/**
 * @author lezha13
 */
public class UndoOperator extends AbstractOperator implements Operator {
    public UndoOperator() {
        super(Collections.emptyList());
    }

    @Override
    public void invoke(Deque<BigDecimal> stack, Deque<Operator> operatorHistory) throws ApplicationException {
        if(operatorHistory.isEmpty()) {
            return;
        }
        Operator operator = operatorHistory.pop();
        operator.undo(stack);
    }

    @Override
    public void undo(Deque<BigDecimal> stack) {

    }
}
