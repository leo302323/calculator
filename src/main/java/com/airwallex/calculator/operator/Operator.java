package com.airwallex.calculator.operator;

import com.airwallex.calculator.exception.ApplicationException;

import java.math.BigDecimal;
import java.util.Deque;

/**
 * The interface Operator.
 *
 * @author lezha13
 */
public interface Operator {
    /**
     * Invoke.
     *
     * @param stack           the stack
     * @param operatorHistory the operator history
     * @throws ApplicationException the application exception
     */
    void invoke(Deque<BigDecimal> stack, Deque<Operator> operatorHistory) throws ApplicationException;

    /**
     * Undo.
     *  @param stack           the stack
     *
     */
    void undo(Deque<BigDecimal> stack);
}
