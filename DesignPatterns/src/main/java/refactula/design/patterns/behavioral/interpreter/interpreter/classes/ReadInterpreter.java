package refactula.design.patterns.behavioral.interpreter.interpreter.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Read;
import refactula.design.patterns.behavioral.interpreter.interpreter.IO;
import refactula.design.patterns.behavioral.interpreter.interpreter.Interpreter;
import refactula.design.patterns.behavioral.interpreter.interpreter.InterpreterContext;

public class ReadInterpreter extends Interpreter<Read, Void> {
    private final IO inputOutput;
    private final VariableInterpreter variableInterpreter;

    public ReadInterpreter(IO inputOutput, VariableInterpreter variableInterpreter) {
        super(Read.class);
        this.inputOutput = inputOutput;
        this.variableInterpreter = variableInterpreter;
    }

    @Override
    protected Void doInterpret(InterpreterContext context, Read expression) {
        variableInterpreter.init(expression.getVariable(), inputOutput.read());
        return null;
    }
}
