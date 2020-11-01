package com.airwallex.calculator.operator.impl;

import com.airwallex.calculator.exception.ApplicationException;
import com.airwallex.calculator.operator.Operator;
import com.airwallex.calculator.operator.impl.AbstractOperator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author lezha13
 */
public class SubtractOperator extends AbstractOperator implements Operator {
    public SubtractOperator() {
        super(new ArrayList<>());
    }

    @Override
    public void invoke(Deque<BigDecimal> stack, Deque<Operator> operatorHistory) throws ApplicationException {
        minimumOperandsCheck(stack, 2);
        BigDecimal second = stack.pop();
        BigDecimal first = stack.pop();
        stack.push(first.subtract(second));
        this.data.add(first);
        this.data.add(second);
        operatorHistory.push(this);
    }
}
