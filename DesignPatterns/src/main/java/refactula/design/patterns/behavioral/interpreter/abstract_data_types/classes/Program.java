package refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.CommandType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.ProgramType;

public class Program implements ProgramType {
    private final CommandType command;

    public Program(CommandType command) {
        this.command = command;
    }

    public CommandType getCommand() {
        return command;
    }

    @Override
    public String toString() {
        return "Program{" +
                "command=" + command +
                '}';
    }
}
