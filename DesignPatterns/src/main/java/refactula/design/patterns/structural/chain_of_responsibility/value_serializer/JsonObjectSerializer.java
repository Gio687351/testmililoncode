package refactula.design.patterns.structural.chain_of_responsibility.value_serializer;

import refactula.design.patterns.structural.composite.JsonObject;
import refactula.design.patterns.structural.composite.JsonString;
import refactula.design.patterns.structural.composite.JsonValue;

import java.util.Map.Entry;

public class JsonObjectSerializer extends AbstractJsonSerializer<JsonObject> {
    public JsonObjectSerializer(JsonValueSerializer delegate) {
        super(JsonObject.class, delegate);
    }

    @Override
    protected void doAppend(JsonValueSerializer root, StringBuilder builder, JsonObject value) {
        builder.append('{');
        boolean shouldDelimit = false;
        for (Entry<JsonString, JsonValue> pair : value.getPairs().entrySet()) {
            if (shouldDelimit) {
                builder.append(',');
            }
            root.append(root, builder, pair.getKey());
            builder.append(':');
            root.append(root, builder, pair.getValue());
            shouldDelimit = true;
        }
        builder.append('}');
    }
}
