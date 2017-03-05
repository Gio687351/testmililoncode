package refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.CommandType;

public class Read implements CommandType {
    private final Variable variable;

    public Read(Variable variable) {
        this.variable = variable;
    }

    public Variable getVariable() {
        return variable;
    }

    @Override
    public String toString() {
        return "Read{" +
                "variable=" + variable +
                '}';
    }
}
