package refactula.design.patterns.creational.factory.file;

import java.util.Base64;

public class StringEncoder {
    private final StringConverter stringConverter;

    public StringEncoder(StringConverter stringConverter) {
        this.stringConverter = stringConverter;
    }

    public String encode(String key) {
        return Base64.getEncoder().encodeToString(stringConverter.getBytes(key));
    }
}
