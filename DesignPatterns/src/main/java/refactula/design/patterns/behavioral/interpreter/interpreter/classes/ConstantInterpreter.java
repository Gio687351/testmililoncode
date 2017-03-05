package refactula.design.patterns.behavioral.interpreter.interpreter.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Constant;
import refactula.design.patterns.behavioral.interpreter.interpreter.Interpreter;
import refactula.design.patterns.behavioral.interpreter.interpreter.InterpreterContext;

public class ConstantInterpreter extends Interpreter<Constant, String> {

    public ConstantInterpreter() {
        super(Constant.class);
    }

    @Override
    protected String doInterpret(InterpreterContext context, Constant expression) {
        return expression.getValue();
    }

}
