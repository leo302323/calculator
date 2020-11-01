package com.airwallex.calculator.operator.impl;

import com.airwallex.calculator.exception.ApplicationException;
import com.airwallex.calculator.operator.Operator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author lezha13
 */
public class SqrtOperator extends AbstractOperator implements Operator {
    public SqrtOperator() {
        super(new ArrayList<>());
    }

    @Override
    public void invoke(Deque<BigDecimal> stack, Deque<Operator> operatorHistory) throws ApplicationException {
        minimumOperandsCheck(stack, 1);
        BigDecimal val = stack.pop();
        BigDecimal x = BigDecimal.valueOf(Math.sqrt(val.doubleValue()));
        x = x.setScale(15, BigDecimal.ROUND_DOWN);
        stack.push(x);
        this.data.add(val);
        operatorHistory.push(this);
    }
}
