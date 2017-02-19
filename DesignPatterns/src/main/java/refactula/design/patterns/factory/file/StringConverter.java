package refactula.design.patterns.factory.file;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringConverter {
    private final Charset charset;

    public static final StringConverter UTF_8 = new StringConverter(StandardCharsets.UTF_8);

    public StringConverter(Charset charset) {
        this.charset = charset;
    }

    public byte[] getBytes(String key) {
        return key.getBytes(charset);
    }

    public String toString(byte[] bytes) throws IOException {
        return new String(bytes, charset);
    }
}
