package refactula.design.patterns.structural.composite;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class JsonObjectTest {

    @Test
    public void testJsonObject() {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(new PrintWriter(stringWriter));
        JsonObject jsonObject = new JsonObject(ImmutableMap.of(
                "escapedString", new JsonString("two lines\n\twhich are \"perfectly\" escaped"),
                "amount", new JsonInt(5),
                "emptyObject", new JsonObject(ImmutableMap.of()),
                "array", new JsonArray(ImmutableList.of(
                        new JsonString("one"),
                        new JsonString("two"),
                        new JsonString("three")
                )),
                "nested", new JsonObject(ImmutableMap.of(
                        "nullValue", new JsonNullValue(),
                        "doubleValue", new JsonDouble(3.1415),
                        "allGood", new JsonBooleanValue(true)
                ))));
        jsonObject.write(jsonWriter);
        String json = stringWriter.toString();
        assertEquals("{\"escapedString\":\"two lines\\n\\twhich are \\\"perfectly\\\" escaped\",\"amount\":5," +
                "\"emptyObject\":{},\"array\":[\"one\",\"two\",\"three\"],\"nested\":{\"nullValue\":null," +
                "\"doubleValue\":3.1415,\"allGood\":true}}", json);
    }

}