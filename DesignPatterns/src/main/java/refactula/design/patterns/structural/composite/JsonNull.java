package refactula.design.patterns.structural.composite;

import refactula.design.patterns.structural.composite.writer.JsonWriter;

public class JsonNull implements JsonValue {
    @Override
    public void write(JsonWriter jsonWriter) {
        jsonWriter.writeNull();
    }
}
