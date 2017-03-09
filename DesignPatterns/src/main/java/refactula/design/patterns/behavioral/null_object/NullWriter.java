package refactula.design.patterns.behavioral.null_object;

import java.io.Writer;

public final class NullWriter extends Writer {
    public static final NullWriter INSTANCE = new NullWriter();

    private NullWriter() {
        // private constructor
    }

    @Override
    public void write(char[] cbuf, int off, int len) {
        // do nothing
    }

    @Override
    public void flush() {
        // do nothing
    }

    @Override
    public void close() {
        // do nothing
    }
}
