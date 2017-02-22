package refactula.design.patterns.structural.decorator.line_stream;

public class LengthLimitingStream extends ForwardingLineStream {
    private final int maxLength;

    public LengthLimitingStream(int maxLength, LineStream delegate) {
        super(delegate);
        this.maxLength = maxLength;
    }

    @Override
    public void printLine(String line) {
        super.printLine(line.length() > maxLength ? line.substring(0, maxLength) : line);
    }
}
