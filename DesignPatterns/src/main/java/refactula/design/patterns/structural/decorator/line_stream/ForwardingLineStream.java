package refactula.design.patterns.structural.decorator.line_stream;

public class ForwardingLineStream implements LineStream {
    private final LineStream delegate;

    public ForwardingLineStream(LineStream delegate) {
        this.delegate = delegate;
    }

    @Override
    public void printLine(String line) {
        delegate.printLine(line);
    }
}
