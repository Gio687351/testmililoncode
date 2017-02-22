package refactula.design.patterns.structural.composite;

public class JsonDouble implements JsonValue {
    private final double value;

    public JsonDouble(double value) {
        this.value = value;
    }

    @Override
    public void write(JsonWriter jsonWriter) {
        jsonWriter.writeDouble(value);
    }
}
