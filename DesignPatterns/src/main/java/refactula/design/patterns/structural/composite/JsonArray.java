package refactula.design.patterns.structural.composite;

import com.google.common.collect.ImmutableList;

public class JsonArray implements JsonValue {
    private final ImmutableList<JsonValue> values;

    public JsonArray(ImmutableList<JsonValue> values) {
        this.values = values;
    }

    @Override
    public void write(JsonWriter jsonWriter) {
        jsonWriter.startArray();
        boolean isContinuation = false;
        for (JsonValue value : values) {
            if (isContinuation) {
                jsonWriter.delimitArrayValues();
            }
            value.write(jsonWriter);
            isContinuation = true;
        }
        jsonWriter.endArray();
    }
}
