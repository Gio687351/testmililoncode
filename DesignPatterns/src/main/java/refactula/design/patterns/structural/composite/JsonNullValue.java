package refactula.design.patterns.structural.composite;

public class JsonNullValue implements JsonValue {
    @Override
    public void write(JsonWriter jsonWriter) {
        jsonWriter.writeNull();
    }
}
