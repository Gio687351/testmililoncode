package refactula.design.patterns.behavioral.interpreter.abstract_data_types.classes;

import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.CommandType;
import refactula.design.patterns.behavioral.interpreter.abstract_data_types.types.StringType;

public class Show implements CommandType {
    private final StringType text;

    public Show(StringType text) {
        this.text = text;
    }

    public StringType getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Show{" +
                "text=" + text +
                '}';
    }
}
