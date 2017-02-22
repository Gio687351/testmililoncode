package refactula.design.patterns.structural.chain_of_responsibility.value_serializer;

import refactula.design.patterns.structural.composite.JsonValue;

public class ForwardingJsonSerializer implements JsonValueSerializer {
    private final JsonValueSerializer delegate;

    public ForwardingJsonSerializer(JsonValueSerializer delegate) {
        this.delegate = delegate;
    }

    @Override
    public void append(JsonValueSerializer root, StringBuilder builder, JsonValue jsonValue) {
        delegate.append(root, builder, jsonValue);
    }
}
