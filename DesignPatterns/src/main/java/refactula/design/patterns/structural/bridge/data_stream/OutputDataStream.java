package refactula.design.patterns.structural.bridge.data_stream;

import refactula.design.patterns.structural.bridge.DataStream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;

public class OutputDataStream implements DataStream {
    private final OutputStream stream;

    public static OutputDataStream systemOut() {
        return new OutputDataStream(System.out);
    }

    public OutputDataStream(OutputStream stream) {
        this.stream = stream;
    }

    @Override
    public void write(byte[] data) {
        try {
            stream.write(data);
            stream.flush();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
