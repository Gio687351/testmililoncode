package refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer;

import com.google.common.collect.ImmutableMap;
import refactula.design.patterns.structural.composite.JsonString;

public class JsonStringSerializer extends AbstractJsonSerializer<JsonString> {
    private static final ImmutableMap<Character, String> ESCAPING = ImmutableMap.<Character, String>builder()
            .put('\b', "\\b")
            .put('\f', "\\f")
            .put('\n', "\\n")
            .put('\r', "\\r")
            .put('\t', "\\t")
            .put('"', "\\\"")
            .put('\\', "\\\\")
            .build();

    public JsonStringSerializer(JsonValueSerializer delegate) {
        super(JsonString.class, delegate);
    }

    @Override
    protected void doAppend(JsonValueSerializer root, StringBuilder builder, JsonString value) {
        String s = value.get();
        builder.append('"');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String escapeSequence = ESCAPING.get(ch);
            if (escapeSequence != null) {
                builder.append(escapeSequence);
            } else {
                builder.append(ch);
            }
        }
        builder.append('"');
    }
}
