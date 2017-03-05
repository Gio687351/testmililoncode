package refactula.design.patterns.behavioral.interpreter.interpreter.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Show;
import refactula.design.patterns.behavioral.interpreter.interpreter.IO;
import refactula.design.patterns.behavioral.interpreter.interpreter.Interpreter;
import refactula.design.patterns.behavioral.interpreter.interpreter.InterpreterContext;

public class ShowInterpreter extends Interpreter<Show, Void> {
    private final IO inputOutput;

    public ShowInterpreter(IO inputOutput) {
        super(Show.class);
        this.inputOutput = inputOutput;
    }

    @Override
    protected Void doInterpret(InterpreterContext context, Show expression) {
        inputOutput.show(context.interpret(expression.getText()));
        return null;
    }
}
