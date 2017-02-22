package refactula.design.patterns.structural.composite;

import com.google.common.collect.ImmutableMap;
import refactula.design.patterns.structural.composite.writer.JsonWriter;

import java.util.Map.Entry;

public class JsonObject implements JsonValue {
    private final ImmutableMap<JsonString, JsonValue> pairs;

    public JsonObject(ImmutableMap<JsonString, JsonValue> pairs) {
        this.pairs = pairs;
    }

    public ImmutableMap<JsonString, JsonValue> getPairs() {
        return pairs;
    }

    public void write(JsonWriter jsonWriter) {
        jsonWriter.startObject();
        boolean isContinuation = false;
        for (Entry<JsonString, JsonValue> pair : pairs.entrySet()) {
            if (isContinuation) {
                jsonWriter.delimitPairs();
            }
            jsonWriter.writeStringValue(pair.getKey().get());
            jsonWriter.delimitPairKeyAndValue();
            pair.getValue().write(jsonWriter);
            isContinuation = true;
        }
        jsonWriter.endObject();
    }
}
