package refactula.design.patterns.behavioral.interpreter.interpreter.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Equals;
import refactula.design.patterns.behavioral.interpreter.interpreter.Interpreter;
import refactula.design.patterns.behavioral.interpreter.interpreter.InterpreterContext;

import java.util.Objects;

public class EqualsInterpreter extends Interpreter<Equals, Boolean> {

    public EqualsInterpreter() {
        super(Equals.class);
    }

    @Override
    protected Boolean doInterpret(InterpreterContext context, Equals expression) {
        return Objects.equals(
                context.interpret(expression.getFirst()),
                context.interpret(expression.getSecond()));
    }

}
