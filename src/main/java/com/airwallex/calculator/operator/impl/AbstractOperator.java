package com.airwallex.calculator.operator.impl;

import com.airwallex.calculator.exception.ApplicationException;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @author lezha13
 */
public abstract class AbstractOperator {
    protected List<BigDecimal> data;

    AbstractOperator(List<BigDecimal> data) {
        this.data = data;
    }

    protected void inputStack(Deque<BigDecimal> stack) {
        data.forEach(stack::push);
    }

    protected void minimumOperandsCheck(Deque<BigDecimal> stack, int count) throws ApplicationException {
        if (stack.size() < count) {
            throw new ApplicationException("insufficient parameters");
        }
    }

    public void undo(Deque<BigDecimal> stack) {
        if(stack.size() > 0) {
            stack.pop();
            inputStack(stack);
        }
    }
}
