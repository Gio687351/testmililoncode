package refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.StringType;

public class Variable implements StringType {
    @Override
    public String toString() {
        return "Variable@" + hashCode();
    }
}
