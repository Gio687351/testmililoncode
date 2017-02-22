package refactula.design.patterns.structural.composite;

import com.google.common.collect.ImmutableMap;

import java.util.Map.Entry;

public class JsonObject implements JsonValue {
    private final ImmutableMap<String, JsonValue> pairs;

    public JsonObject(ImmutableMap<String, JsonValue> pairs) {
        this.pairs = pairs;
    }

    public void write(JsonWriter jsonWriter) {
        jsonWriter.startObject();
        boolean isContinuation = false;
        for (Entry<String, JsonValue> pair : pairs.entrySet()) {
            if (isContinuation) {
                jsonWriter.delimitPairs();
            }
            jsonWriter.writePairKey(pair.getKey());
            jsonWriter.delimitPairKeyAndValue();
            pair.getValue().write(jsonWriter);
            isContinuation = true;
        }
        jsonWriter.endObject();
    }
}
