package refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes;

import com.google.common.collect.ImmutableList;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.StringType;

public class Concat implements StringType {
    private final ImmutableList<StringType> values;

    public Concat(ImmutableList<StringType> values) {
        this.values = values;
    }

    public ImmutableList<StringType> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Concat{" +
                "values=" + values +
                '}';
    }
}
