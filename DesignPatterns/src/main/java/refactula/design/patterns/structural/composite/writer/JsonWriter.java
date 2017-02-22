package refactula.design.patterns.structural.composite.writer;

import java.io.PrintWriter;

public class JsonWriter {
    private final PrintWriter printWriter;

    public JsonWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public void startObject() {
        printWriter.print("{");
    }

    public void endObject() {
        printWriter.print("}");
    }

    public void delimitPairs() {
        printWriter.print(",");
    }

    public void delimitPairKeyAndValue() {
        printWriter.print(":");
    }

    public void writeStringValue(String value) {
        printWriter.print("\"");
        escapeAndPrint(value);
        printWriter.print("\"");
    }

    private void escapeAndPrint(String value) {
        for (int i = 0; i < value.length(); i++) {
            printWriter.print(escaped(value.charAt(i)));
        }
    }

    private String escaped(char ch) {
        switch (ch) {
            case '\b':
                return "\\b";
            case '\f':
                return "\\f";
            case '\n':
                return "\\n";
            case '\r':
                return "\\r";
            case '\t':
                return "\\t";
            case '"':
                return "\\\"";
            case '\\':
                return "\\\\";
            default:
                return String.valueOf(ch);
        }
    }

    public void writeIntValue(int value) {
        printWriter.print(value);
    }

    public void writeBooleanValue(boolean value) {
        printWriter.print(value);
    }

    public void writeNull() {
        printWriter.print("null");
    }

    public void startArray() {
        printWriter.print("[");
    }

    public void endArray() {
        printWriter.print("]");
    }

    public void delimitArrayValues() {
        printWriter.print(",");
    }

    public void writeDouble(double value) {
        printWriter.print(value);
    }
}
