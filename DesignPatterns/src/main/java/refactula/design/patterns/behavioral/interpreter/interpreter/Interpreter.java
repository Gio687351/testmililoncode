package refactula.design.patterns.behavioral.interpreter.interpreter;

import com.google.common.base.Preconditions;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.Expression;

public abstract class Interpreter<E extends Expression, T> {
    private final Class<E> expressionClass;

    protected Interpreter(Class<E> expressionClass) {
        this.expressionClass = expressionClass;
    }

    public boolean canInterpret(Expression expression) {
        return expressionClass.isAssignableFrom(expression.getClass());
    }

    public final T interpret(InterpreterContext context, Expression expression) {
        Preconditions.checkArgument(canInterpret(expression));
        return doInterpret(context, expressionClass.cast(expression));
    }

    protected abstract T doInterpret(InterpreterContext context, E expression);
}
