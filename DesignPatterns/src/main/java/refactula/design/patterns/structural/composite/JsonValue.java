package refactula.design.patterns.structural.composite;

import refactula.design.patterns.structural.composite.writer.JsonWriter;

public interface JsonValue {

    void write(JsonWriter jsonWriter);

}
