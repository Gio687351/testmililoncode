package refactula.design.patterns.structural.composite;

import com.google.common.collect.ImmutableList;
import refactula.design.patterns.structural.composite.writer.JsonWriter;

public class JsonArray implements JsonValue {
    private final ImmutableList<JsonValue> values;

    public JsonArray(ImmutableList<JsonValue> values) {
        this.values = values;
    }

    public ImmutableList<JsonValue> getValues() {
        return values;
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
