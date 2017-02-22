package refactula.design.patterns.structural.decorator.line_stream;

public class FixedPrefixStream extends ForwardingLineStream {
    private final String prefix;

    public FixedPrefixStream(String prefix, LineStream delegate) {
        super(delegate);
        this.prefix = prefix;
    }

    @Override
    public void printLine(String line) {
        super.printLine(prefix + line);
    }
}
