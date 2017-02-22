package refactula.design.patterns.structural.composite;

public class JsonInt implements JsonValue {
    private final int value;

    public JsonInt(int value) {
        this.value = value;
    }

    @Override
    public void write(JsonWriter jsonWriter) {
        jsonWriter.writeIntValue(value);
    }
}
