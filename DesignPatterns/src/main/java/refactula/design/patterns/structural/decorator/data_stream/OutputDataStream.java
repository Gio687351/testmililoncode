package refactula.design.patterns.structural.decorator.data_stream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;

public class OutputDataStream implements DataStream {
    private final OutputStream outputStream;

    public static OutputDataStream sysOut() {
        return new OutputDataStream(System.out);
    }

    public OutputDataStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void writeBytes(byte[] bytes) {
        try {
            outputStream.write(bytes);
            outputStream.flush();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
