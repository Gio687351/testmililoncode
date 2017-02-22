package refactula.design.patterns.structural.decorator.string_stream;

public class LowerCaseStringStream extends ForwardingStringStream {
    public LowerCaseStringStream(StringStream delegate) {
        super(delegate);
    }

    @Override
    public void print(String s) {
        super.print(s.toLowerCase());
    }
}
