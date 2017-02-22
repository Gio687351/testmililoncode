package refactula.design.patterns.structural.decorator.line_stream;

import java.time.Clock;
import java.time.format.DateTimeFormatter;

public class TimestampAppendingStream extends ForwardingLineStream {
    private final Clock clock;

    public TimestampAppendingStream(Clock clock, LineStream delegate) {
        super(delegate);
        this.clock = clock;
    }

    @Override
    public void printLine(String line) {
        String timestamp = DateTimeFormatter.ISO_INSTANT.format(clock.instant());
        super.printLine(timestamp + " " + line);
    }
}
