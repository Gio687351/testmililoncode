package refactula.design.patterns.behavioral.interpreter.interpreter;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.BooleanType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.CommandType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.ProgramType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.StringType;

public class RootInterpreter implements InterpreterContext {
    private final Interpreter<ProgramType, Void> programInterpreter;
    private final Interpreter<StringType, String> stringInterpreter;
    private final Interpreter<CommandType, Void> commandInterpreter;
    private final Interpreter<BooleanType, Boolean> booleanInterpreter;

    public RootInterpreter(
            Interpreter<ProgramType, Void> programInterpreter,
            Interpreter<StringType, String> stringInterpreter,
            Interpreter<CommandType, Void> commandInterpreter,
            Interpreter<BooleanType, Boolean> booleanInterpreter) {

        this.programInterpreter = programInterpreter;
        this.stringInterpreter = stringInterpreter;
        this.commandInterpreter = commandInterpreter;
        this.booleanInterpreter = booleanInterpreter;
    }

    @Override
    public void interpret(ProgramType program) {
        programInterpreter.interpret(this, program);
    }

    @Override
    public String interpret(StringType string) {
        return stringInterpreter.interpret(this, string);
    }

    @Override
    public void interpret(CommandType command) {
        commandInterpreter.interpret(this, command);
    }

    @Override
    public boolean interpret(BooleanType booleanType) {
        return booleanInterpreter.interpret(this, booleanType);
    }
}
