package refactula.design.patterns.structural.composite;

import refactula.design.patterns.structural.composite.writer.JsonWriter;

public class JsonDouble implements JsonValue {
    private final double value;

    public JsonDouble(double value) {
        this.value = value;
    }

    public double get() {
        return value;
    }

    @Override
    public void write(JsonWriter jsonWriter) {
        jsonWriter.writeDouble(value);
    }
}
