package refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.BooleanType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.StringType;

public class Equals implements BooleanType {
    private final StringType first;
    private final StringType second;

    public Equals(StringType first, StringType second) {
        this.first = first;
        this.second = second;
    }

    public StringType getFirst() {
        return first;
    }

    public StringType getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Equals{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
