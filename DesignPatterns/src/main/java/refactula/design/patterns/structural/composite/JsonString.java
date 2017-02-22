package refactula.design.patterns.structural.composite;

import com.google.common.base.Objects;
import refactula.design.patterns.structural.composite.writer.JsonWriter;

public class JsonString implements JsonValue {
    private final String value;

    public JsonString(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }

    @Override
    public void write(JsonWriter jsonWriter) {
        jsonWriter.writeStringValue(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonString that = (JsonString) o;
        return Objects.equal(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
