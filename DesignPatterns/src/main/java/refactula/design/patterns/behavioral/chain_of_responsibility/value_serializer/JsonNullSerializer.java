package refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer;

import refactula.design.patterns.structural.composite.JsonNull;

public class JsonNullSerializer extends AbstractJsonSerializer<JsonNull> {
    public JsonNullSerializer(JsonValueSerializer delegate) {
        super(JsonNull.class, delegate);
    }

    @Override
    protected void doAppend(JsonValueSerializer root, StringBuilder builder, JsonNull value) {
        builder.append("null");
    }
}
