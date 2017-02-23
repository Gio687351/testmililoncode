package refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer;

import refactula.design.patterns.structural.composite.JsonBoolean;

public class JsonBooleanSerializer extends AbstractJsonSerializer<JsonBoolean> {
    public JsonBooleanSerializer(JsonValueSerializer delegate) {
        super(JsonBoolean.class, delegate);
    }

    @Override
    protected void doAppend(JsonValueSerializer root, StringBuilder builder, JsonBoolean value) {
        builder.append(value.get());
    }
}
