package com.airwallex.calculator.command;

import com.airwallex.calculator.exception.ApplicationException;
import com.airwallex.calculator.operator.Operator;

import java.math.BigDecimal;
import java.util.Deque;

/**
 * @author lezha13
 */
@FunctionalInterface
public interface Command {
    /**
     * Invoke.
     *
     * @param stack           the stack
     * @param operatorHistory the operator history
     * @param value           the value
     * @throws ApplicationException the application exception
     */
    void invoke(Deque<BigDecimal> stack, Deque<Operator> operatorHistory, BigDecimal value) throws ApplicationException;
}
