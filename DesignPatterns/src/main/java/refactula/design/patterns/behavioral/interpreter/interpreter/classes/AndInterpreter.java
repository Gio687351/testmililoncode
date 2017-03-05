package refactula.design.patterns.behavioral.interpreter.interpreter.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.And;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.BooleanType;
import refactula.design.patterns.behavioral.interpreter.interpreter.Interpreter;
import refactula.design.patterns.behavioral.interpreter.interpreter.InterpreterContext;

public class AndInterpreter extends Interpreter<And, Boolean> {

    public AndInterpreter() {
        super(And.class);
    }

    @Override
    protected Boolean doInterpret(InterpreterContext context, And expression) {
        for (BooleanType condition : expression.getConditions()) {
            if (!context.interpret(condition)) {
                return false;
            }

        }
        return true;
    }

}
