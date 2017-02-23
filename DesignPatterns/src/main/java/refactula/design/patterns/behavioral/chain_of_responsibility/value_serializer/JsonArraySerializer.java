package refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer;

import refactula.design.patterns.structural.composite.JsonArray;
import refactula.design.patterns.structural.composite.JsonValue;

public class JsonArraySerializer extends AbstractJsonSerializer<JsonArray> {
    public JsonArraySerializer(JsonValueSerializer delegate) {
        super(JsonArray.class, delegate);
    }

    @Override
    protected void doAppend(JsonValueSerializer root, StringBuilder builder, JsonArray jsonArray) {
        builder.append('[');
        boolean shouldDelimit = false;
        for (JsonValue value : jsonArray.getValues()) {
            if (shouldDelimit) {
                builder.append(',');
            }
            root.append(root, builder, value);
            shouldDelimit = true;
        }
        builder.append(']');
    }
}
