package refactula.design.patterns.structural.decorator.string_stream;

public class ForwardingStringStream implements StringStream {
    private final StringStream delegate;

    public ForwardingStringStream(StringStream delegate) {
        this.delegate = delegate;
    }

    @Override
    public void print(String s) {
        delegate.print(s);
    }
}
