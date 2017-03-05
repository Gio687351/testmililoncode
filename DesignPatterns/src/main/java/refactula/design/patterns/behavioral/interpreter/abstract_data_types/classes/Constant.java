package refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.StringType;

public class Constant implements StringType {
    private final String value;

    public Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Constant{value='" + value + "'}";
    }
}
