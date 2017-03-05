package refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.BooleanType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.CommandType;

public class If implements CommandType {
    private final BooleanType condition;
    private final CommandType trueBranch;
    private final CommandType falseBranch;

    public If(BooleanType condition, CommandType trueBranch, CommandType falseBranch) {
        this.condition = condition;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }

    public BooleanType getCondition() {
        return condition;
    }

    public CommandType getTrueBranch() {
        return trueBranch;
    }

    public CommandType getFalseBranch() {
        return falseBranch;
    }

    @Override
    public String toString() {
        return "If{" +
                "condition=" + condition +
                ", trueBranch=" + trueBranch +
                ", falseBranch=" + falseBranch +
                '}';
    }
}
