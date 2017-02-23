package refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer;

import refactula.design.patterns.structural.composite.JsonValue;

public abstract class AbstractJsonSerializer<T extends JsonValue> extends ForwardingJsonSerializer {
    private final Class<T> valueClass;

    public AbstractJsonSerializer(Class<T> valueClass, JsonValueSerializer delegate) {
        super(delegate);
        this.valueClass = valueClass;
    }

    @Override
    public void append(JsonValueSerializer root, StringBuilder builder, JsonValue jsonValue) {
        if (valueClass.isAssignableFrom(jsonValue.getClass())) {
            doAppend(root, builder, (T) jsonValue);
        } else {
            super.append(root, builder, jsonValue);
        }
    }

    protected abstract void doAppend(JsonValueSerializer root, StringBuilder builder, T value);
}
