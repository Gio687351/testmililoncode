package refactula.design.patterns.structural.composite;

public class JsonBooleanValue implements JsonValue {
    private final boolean value;

    public JsonBooleanValue(boolean value) {
        this.value = value;
    }

    @Override
    public void write(JsonWriter jsonWriter) {
        jsonWriter.writeBooleanValue(value);
    }
}
