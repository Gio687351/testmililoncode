package refactula.design.patterns.behavioral.interpreter.interpreter;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.Expression;

public abstract class Interpreter<E extends Expression> {
    private final Class<E> expessionClass;

    protected Interpreter(Class<E> expessionClass) {
        this.expessionClass = expessionClass;
    }

    public final boolean interpret(Context context, Expression expression) {
        if (expessionClass.isAssignableFrom(expression.getClass())) {
            doInterpret(context, expessionClass.cast(expression));
            return true;
        } else {
            return false;
        }
    }

    protected abstract void doInterpret(Context context, E expression);
}
