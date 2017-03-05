package refactula.design.patterns.behavioral.interpreter.interpreter;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.Expression;

import java.util.List;

public class ChainInterpreter<E extends Expression, T> extends Interpreter<E, T> {
    private final List<Interpreter<? extends E, T>> interpreters;

    public ChainInterpreter(Class<E> superclass, List<Interpreter<? extends E, T>> interpreters) {
        super(superclass);
        this.interpreters = interpreters;
    }

    @Override
    protected T doInterpret(InterpreterContext context, E expression) {
        for (Interpreter<?, T> interpreter : interpreters) {
            if (interpreter.canInterpret(expression)) {
                return interpreter.interpret(context, expression);
            }
        }
        throw new RuntimeException("Interpreter not found: " + expression);
    }
}
