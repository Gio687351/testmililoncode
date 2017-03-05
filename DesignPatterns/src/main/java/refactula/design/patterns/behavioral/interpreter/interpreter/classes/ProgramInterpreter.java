package refactula.design.patterns.behavioral.interpreter.interpreter.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes.Program;
import refactula.design.patterns.behavioral.interpreter.interpreter.Interpreter;
import refactula.design.patterns.behavioral.interpreter.interpreter.InterpreterContext;

public class ProgramInterpreter extends Interpreter<Program, Void> {

    public ProgramInterpreter() {
        super(Program.class);
    }

    @Override
    protected Void doInterpret(InterpreterContext context, Program expression) {
        context.interpret(expression.getCommand());
        return null;
    }

}
