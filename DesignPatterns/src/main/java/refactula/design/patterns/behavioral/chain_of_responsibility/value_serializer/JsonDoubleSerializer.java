package refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer;

import refactula.design.patterns.structural.composite.JsonDouble;

public class JsonDoubleSerializer extends AbstractJsonSerializer<JsonDouble> {
    public JsonDoubleSerializer(JsonValueSerializer delegate) {
        super(JsonDouble.class, delegate);
    }

    @Override
    protected void doAppend(JsonValueSerializer root, StringBuilder builder, JsonDouble value) {
        builder.append(value.get());
    }
}
