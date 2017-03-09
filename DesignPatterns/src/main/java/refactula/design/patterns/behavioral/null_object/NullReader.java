package refactula.design.patterns.behavioral.null_object;

import java.io.Reader;

public final class NullReader extends Reader {
    private static final int END_OF_STREAM = -1;

    public static final NullReader INSTANCE = new NullReader();

    private NullReader() {
        // private constructor
    }

    @Override
    public int read(char[] cbuf, int off, int len) {
        return END_OF_STREAM;
    }

    @Override
    public void close() {
        // do nothing
    }
}
