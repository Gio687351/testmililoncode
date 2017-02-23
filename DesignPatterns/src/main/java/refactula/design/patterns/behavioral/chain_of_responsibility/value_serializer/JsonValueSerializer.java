package refactula.design.patterns.behavioral.chain_of_responsibility.value_serializer;

import refactula.design.patterns.structural.composite.JsonValue;

public interface JsonValueSerializer {
    
    void append(JsonValueSerializer root, StringBuilder builder, JsonValue jsonValue);
    
}
