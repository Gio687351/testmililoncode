package refactula.design.patterns.behavioral.interpreter.interpreter.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Concat;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.StringType;
import refactula.design.patterns.behavioral.interpreter.interpreter.Interpreter;
import refactula.design.patterns.behavioral.interpreter.interpreter.InterpreterContext;

public class ConcatInterpreter extends Interpreter<Concat, String> {

    public ConcatInterpreter() {
        super(Concat.class);
    }

    @Override
    protected String doInterpret(InterpreterContext context, Concat expression) {
        StringBuilder builder = new StringBuilder();
        for (StringType value : expression.getValues()) {
            builder.append(context.interpret(value));
        }
        return builder.toString();
    }

}
