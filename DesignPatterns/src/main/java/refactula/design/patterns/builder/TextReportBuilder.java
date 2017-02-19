package refactula.design.patterns.builder;

public class TextReportBuilder implements ReportBuilder {
    private final String valueSeparator;
    private final String recordSeparator;

    private final StringBuilder stringBuilder = new StringBuilder();
    private boolean firstInRecord = true;

    public static TextReportBuilder commaSeparatedValues() {
        return new TextReportBuilder(",", "\n");
    }

    public static TextReportBuilder tabSeparatedValues() {
        return new TextReportBuilder("\t", "\n");
    }

    public TextReportBuilder(String valueSeparator, String recordSeparator) {
        this.valueSeparator = valueSeparator;
        this.recordSeparator = recordSeparator;
    }

    public String getValueSeparator() {
        return valueSeparator;
    }

    public String getRecordSeparator() {
        return recordSeparator;
    }

    public void reset() {
        stringBuilder.setLength(0);
        firstInRecord = true;
    }

    @Override
    public void addValue(String value) {
        if (firstInRecord) {
            firstInRecord = false;
        } else {
            stringBuilder.append(valueSeparator);
        }
        stringBuilder.append(value);
    }

    @Override
    public void endRecord() {
        stringBuilder.append(recordSeparator);
        firstInRecord = true;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
