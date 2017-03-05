package refactula.design.patterns.behavioral.interpreter.interpreter.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.If;
import refactula.design.patterns.behavioral.interpreter.interpreter.Interpreter;
import refactula.design.patterns.behavioral.interpreter.interpreter.InterpreterContext;

public class IfInterpreter extends Interpreter<If, Void> {

    public IfInterpreter() {
        super(If.class);
    }

    @Override
    protected Void doInterpret(InterpreterContext context, If expression) {
        if (context.interpret(expression.getCondition())) {
            context.interpret(expression.getTrueBranch());
        } else {
            context.interpret(expression.getFalseBranch());
        }
        return null;
    }

}
