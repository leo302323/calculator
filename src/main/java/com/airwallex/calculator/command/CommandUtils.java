package com.airwallex.calculator.command;

import com.airwallex.calculator.exception.ApplicationException;
import com.airwallex.calculator.operator.*;
import com.airwallex.calculator.operator.impl.*;


import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lezha13
 */
public class CommandUtils {

    public static final Command INPUT = ((stack, history, value) -> {
        if (value == null) {
            throw new ApplicationException("insufficient parameters");
        }
        Operator inputOperator = new InputOperator(Collections.singletonList(value));
        inputOperator.invoke(stack, history);
    });

    public static final Command UNDO = ((stack, history, value) -> {
        Operator undoOperator = new UndoOperator();
        undoOperator.invoke(stack, history);
    });

    public static final Command CLEAR = ((stack, history, value) -> {
        Operator clearOperator = new ClearOperator();
        clearOperator.invoke(stack, history);
    });

    public static final Command ADD = ((stack, history, value) -> {
        Operator addOperator = new AddOperator();
        addOperator.invoke(stack, history);
    });

    public static final Command SUBTRACT = ((stack, history, value) -> {
        Operator subtractOperator = new SubtractOperator();
        subtractOperator.invoke(stack, history);
    });

    public static final Command MULTIPLY = ((stack, history, value) -> {
        Operator multiplyOperator = new MultiplyOperator();
        multiplyOperator.invoke(stack, history);
    });

    public static final Command DIVIDE = ((stack, history, value) -> {
        Operator divideOperator = new DivideOperator();
        divideOperator.invoke(stack, history);
    });

    public static final Command SQRT = ((stack, history, value) -> {
        Operator sqrtOperator = new SqrtOperator();
        sqrtOperator.invoke(stack, history);
    });


    public static final Map<String, Command> SUPPORTED_OPERATIONS =
            Collections.unmodifiableMap(Stream.of(
                    new AbstractMap.SimpleEntry<>("+",     ADD),
                    new AbstractMap.SimpleEntry<>("-",     SUBTRACT),
                    new AbstractMap.SimpleEntry<>("*",     MULTIPLY),
                    new AbstractMap.SimpleEntry<>("/",     DIVIDE),
                    new AbstractMap.SimpleEntry<>("sqrt",  SQRT),
                    new AbstractMap.SimpleEntry<>("clear", CLEAR),
                    new AbstractMap.SimpleEntry<>("undo", UNDO))
                    .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)));
}
