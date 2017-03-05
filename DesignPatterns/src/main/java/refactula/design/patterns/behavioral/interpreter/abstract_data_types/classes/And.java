package refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.BooleanType;

import java.util.List;

public class And implements BooleanType {
    private final List<BooleanType> conditions;

    public And(List<BooleanType> conditions) {
        this.conditions = conditions;
    }

    public List<BooleanType> getConditions() {
        return conditions;
    }

    @Override
    public String toString() {
        return "And{" +
                "conditions=" + conditions +
                '}';
    }
}
