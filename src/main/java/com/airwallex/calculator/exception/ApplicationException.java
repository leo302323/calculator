package com.airwallex.calculator.exception;

/**
 * @author lezha13
 */
public class ApplicationException extends RuntimeException {
    public ApplicationException(String msg) {
        super(String.format("%1$s", msg));
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(String op, int pos, String msg) {
        super(String.format("operator %1$s (position: %2$d): %3$s", op, pos, msg));
    }
}
