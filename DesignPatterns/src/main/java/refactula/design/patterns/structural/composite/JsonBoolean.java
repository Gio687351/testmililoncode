package refactula.design.patterns.structural.composite;

import refactula.design.patterns.structural.composite.writer.JsonWriter;

public class JsonBoolean implements JsonValue {
    private final boolean value;

    public JsonBoolean(boolean value) {
        this.value = value;
    }

    public boolean get() {
        return value;
    }

    @Override
    public void write(JsonWriter jsonWriter) {
        jsonWriter.writeBooleanValue(value);
    }
}
