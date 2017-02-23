package refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer;

import refactula.design.patterns.structural.composite.JsonValue;

public class UnknownValueSerializer implements JsonValueSerializer {
    @Override
    public void append(JsonValueSerializer root, StringBuilder builder, JsonValue jsonValue) {
        throw new RuntimeException("Unknown value: " + jsonValue);
    }
}
