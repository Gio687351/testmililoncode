package refactula.design.patterns.structural.decorator.line_stream;

import refactula.design.patterns.structural.decorator.string_stream.StringStream;

public class LineStreamAdapter implements LineStream {
    private final StringStream stringStream;

    public LineStreamAdapter(StringStream stringStream) {
        this.stringStream = stringStream;
    }

    @Override
    public void printLine(String line) {
        stringStream.print(format(line));
    }

    private String format(String line) {
        return escape(new StringBuilder(), line).append('\n').toString();
    }

    private StringBuilder escape(StringBuilder builder, String line) {
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            switch (ch) {
                case '\n':
                    builder.append("\\n");
                    break;
                case '\\':
                    builder.append("\\\\");
                    break;
                default:
                    builder.append(ch);
            }
        }
        return builder;
    }
}
