package refactula.design.patterns.structural.chain_of_responsibility.value_serializer;

import refactula.design.patterns.structural.composite.JsonValue;

public interface JsonValueSerializer {
    
    void append(JsonValueSerializer root, StringBuilder builder, JsonValue jsonValue);
    
}
