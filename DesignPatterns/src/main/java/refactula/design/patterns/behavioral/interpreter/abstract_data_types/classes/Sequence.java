package refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes;

import com.google.common.collect.ImmutableList;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.CommandType;

public class Sequence implements CommandType {
    private final ImmutableList<CommandType> commands;

    public Sequence(ImmutableList<CommandType> commands) {
        this.commands = commands;
    }

    public ImmutableList<CommandType> getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "commands=" + commands +
                '}';
    }
}
