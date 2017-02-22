package refactula.design.patterns.structural.composite;

public class JsonString implements JsonValue {
    private final String value;

    public JsonString(String value) {
        this.value = value;
    }

    @Override
    public void write(JsonWriter jsonWriter) {
        jsonWriter.writeStringValue(value);
    }
}
