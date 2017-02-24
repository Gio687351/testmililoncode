package refactula.design.patterns.structural.proxy.property;

import java.nio.charset.Charset;

public class StringEncoderProperty implements Property<String> {
    private final Property<byte[]> delegate;
    private final Charset charset;

    public StringEncoderProperty(Charset charset, Property<byte[]> delegate) {
        this.charset = charset;
        this.delegate = delegate;
    }

    @Override
    public String get() {
        return new String(delegate.get(), charset);
    }

    @Override
    public void set(String newValue) {
        delegate.set(newValue.getBytes(charset));
    }
}
