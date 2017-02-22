package refactula.design.patterns.structural.chain_of_responsibility;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import refactula.design.patterns.structural.composite.JsonArray;
import refactula.design.patterns.structural.composite.JsonBoolean;
import refactula.design.patterns.structural.composite.JsonDouble;
import refactula.design.patterns.structural.composite.JsonInt;
import refactula.design.patterns.structural.composite.JsonNull;
import refactula.design.patterns.structural.composite.JsonObject;
import refactula.design.patterns.structural.composite.JsonString;

import static org.junit.Assert.assertEquals;

public class JsonSerializerTest {

    @Test
    public void testJsonObject() {
        JsonSerializer jsonSerializer = JsonSerializer.create();
        String json = jsonSerializer.serialize(new JsonObject(ImmutableMap.of(
                new JsonString("escapedString"), new JsonString("two lines\n\twhich are \"perfectly\" escaped"),
                new JsonString("amount"), new JsonInt(5),
                new JsonString("emptyObject"), new JsonObject(ImmutableMap.of()),
                new JsonString("array"), new JsonArray(ImmutableList.of(
                        new JsonString("one"),
                        new JsonString("two"),
                        new JsonString("three")
                )),
                new JsonString("nested"), new JsonObject(ImmutableMap.of(
                        new JsonString("nullValue"), new JsonNull(),
                        new JsonString("doubleValue"), new JsonDouble(3.1415),
                        new JsonString("allGood"), new JsonBoolean(true)
                )))));
        assertEquals("{\"escapedString\":\"two lines\\n\\twhich are \\\"perfectly\\\" escaped\",\"amount\":5," +
                "\"emptyObject\":{},\"array\":[\"one\",\"two\",\"three\"],\"nested\":{\"nullValue\":null," +
                "\"doubleValue\":3.1415,\"allGood\":true}}", json);
    }

}