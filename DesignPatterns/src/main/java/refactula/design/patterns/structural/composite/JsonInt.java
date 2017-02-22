package refactula.design.patterns.structural.composite;

import refactula.design.patterns.structural.composite.writer.JsonWriter;

public class JsonInt implements JsonValue {
    private final int value;

    public JsonInt(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }

    @Override
    public void write(JsonWriter jsonWriter) {
        jsonWriter.writeIntValue(value);
    }
}
