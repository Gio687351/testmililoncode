package refactula.design.patterns.creational.builder;

import com.google.common.base.Preconditions;

public class XMLReportBuilder implements ReportBuilder {
    private final String rootTag;
    private final String recordTag;
    private final String valueTag;

    private final StringBuilder stringBuilder = new StringBuilder();
    private boolean finished = false;
    private boolean recordTagStarted = false;

    public XMLReportBuilder(String rootTag, String recordTag, String valueTag) {
        this.rootTag = rootTag;
        this.recordTag = recordTag;
        this.valueTag = valueTag;
        openTag(rootTag);
    }

    private void openTag(String tag) {
        stringBuilder.append("<").append(tag).append(">");
    }

    private void closeTag(String tag) {
        stringBuilder.append("</").append(tag).append(">");
    }

    public String generateReport() {
        if (!finished) {
            endRecord();
            closeTag(rootTag);
            finished = true;
        }
        return stringBuilder.toString();
    }

    @Override
    public void addValue(String value) {
        Preconditions.checkState(!finished);
        startRecord();
        openTag(valueTag);
        stringBuilder.append(value);
        closeTag(valueTag);
    }

    private void startRecord() {
        if (!recordTagStarted) {
            openTag(recordTag);
            recordTagStarted = true;
        }
    }

    @Override
    public void endRecord() {
        Preconditions.checkState(!finished);
        if (recordTagStarted) {
            closeTag(recordTag);
            recordTagStarted = false;
        }
    }
}
