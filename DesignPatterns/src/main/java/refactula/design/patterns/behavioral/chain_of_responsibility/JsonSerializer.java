package refactula.design.patterns.behavioral.chain_of_responsibility;

import refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer.JsonArraySerializer;
import refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer.JsonBooleanSerializer;
import refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer.JsonDoubleSerializer;
import refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer.JsonIntSerializer;
import refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer.JsonNullSerializer;
import refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer.JsonObjectSerializer;
import refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer.JsonStringSerializer;
import refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer.JsonValueSerializer;
import refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer.UnknownValueSerializer;
import refactula.design.patterns.structural.composite.JsonValue;

public class JsonSerializer {
    private final JsonValueSerializer valueSerializer;

    public static JsonSerializer create() {
        return compose(new UnknownValueSerializer(),
                JsonArraySerializer::new,
                JsonBooleanSerializer::new,
                JsonDoubleSerializer::new,
                JsonIntSerializer::new,
                JsonNullSerializer::new,
                JsonObjectSerializer::new,
                JsonStringSerializer::new);
    }

    private static JsonSerializer compose(JsonValueSerializer serializer, JsonValueSerializerFactory... factories) {
        for (JsonValueSerializerFactory factory : factories) {
            serializer = factory.create(serializer);
        }
        return new JsonSerializer(serializer);
    }

    public JsonSerializer(JsonValueSerializer valueSerializer) {
        this.valueSerializer = valueSerializer;
    }

    public String serialize(JsonValue value) {
        StringBuilder builder = new StringBuilder();
        valueSerializer.append(valueSerializer, builder, value);
        return builder.toString();
    }

    private interface JsonValueSerializerFactory {
        JsonValueSerializer create(JsonValueSerializer next);
    }
}
