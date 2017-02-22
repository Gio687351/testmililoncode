package refactula.design.patterns.structural.decorator.string_stream;

import refactula.design.patterns.structural.decorator.data_stream.DataStream;

import java.nio.charset.StandardCharsets;

public class StringStreamAdapter implements StringStream {
    private final DataStream dataStream;

    public StringStreamAdapter(DataStream dataStream) {
        this.dataStream = dataStream;
    }

    @Override
    public void print(String s) {
        dataStream.writeBytes(s.getBytes(StandardCharsets.UTF_8));
    }
}
