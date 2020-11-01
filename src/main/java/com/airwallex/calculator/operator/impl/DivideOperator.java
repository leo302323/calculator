package com.airwallex.calculator.operator.impl;

import com.airwallex.calculator.exception.ApplicationException;
import com.airwallex.calculator.operator.Operator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author lezha13
 */
public class DivideOperator extends AbstractOperator implements Operator {
    public DivideOperator() {
        super(new ArrayList<>());
    }

    @Override
    public void invoke(Deque<BigDecimal> stack, Deque<Operator> operatorHistory) throws ApplicationException {
        minimumOperandsCheck(stack, 2);
        BigDecimal second = stack.pop();
        BigDecimal first = stack.pop();
        BigDecimal result;
        try {
            result = first.divide(second, MathContext.DECIMAL128);
        } catch (Exception e) {
            throw new ApplicationException("Invalid Parameters");
        }
        stack.push(result);
        this.data.add(first);
        this.data.add(second);
        operatorHistory.push(this);
    }
}
