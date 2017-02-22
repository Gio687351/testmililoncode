package refactula.design.patterns.structural.chain_of_responsibility.value_serializer;

import refactula.design.patterns.structural.composite.JsonInt;

public class JsonIntSerializer extends AbstractJsonSerializer<JsonInt> {
    public JsonIntSerializer(JsonValueSerializer delegate) {
        super(JsonInt.class, delegate);
    }

    @Override
    protected void doAppend(JsonValueSerializer root, StringBuilder builder, JsonInt value) {
        builder.append(value.get());
    }
}
