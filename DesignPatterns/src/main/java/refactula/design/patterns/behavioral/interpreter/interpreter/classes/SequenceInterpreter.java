package refactula.design.patterns.behavioral.interpreter.interpreter.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Sequence;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.CommandType;
import refactula.design.patterns.behavioral.interpreter.interpreter.Interpreter;
import refactula.design.patterns.behavioral.interpreter.interpreter.InterpreterContext;

public class SequenceInterpreter extends Interpreter<Sequence, Void> {

    public SequenceInterpreter() {
        super(Sequence.class);
    }

    @Override
    protected Void doInterpret(InterpreterContext context, Sequence expression) {
        for (CommandType command : expression.getCommands()) {
            context.interpret(command);
        }
        return null;
    }

}
