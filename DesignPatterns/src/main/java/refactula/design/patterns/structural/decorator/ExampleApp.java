package refactula.design.patterns.structural.decorator;

import com.google.common.base.MoreObjects;
import refactula.design.patterns.structural.decorator.data_stream.OutputDataStream;
import refactula.design.patterns.structural.decorator.event_stream.EventStream;
import refactula.design.patterns.structural.decorator.event_stream.StringEventStream;
import refactula.design.patterns.structural.decorator.line_stream.FixedPrefixStream;
import refactula.design.patterns.structural.decorator.line_stream.LengthLimitingStream;
import refactula.design.patterns.structural.decorator.line_stream.LineStreamAdapter;
import refactula.design.patterns.structural.decorator.line_stream.TimestampAppendingStream;
import refactula.design.patterns.structural.decorator.string_stream.LowerCaseStringStream;
import refactula.design.patterns.structural.decorator.string_stream.StringStreamAdapter;

import java.time.Clock;

public class ExampleApp {

    public static void main(String[] args) {
        EventStream<Event> eventStream = new StringEventStream<>(Event::toString,
                new LengthLimitingStream(100,
                new FixedPrefixStream("INFO ",
                new TimestampAppendingStream(Clock.systemUTC(),
                new LineStreamAdapter(
                new LowerCaseStringStream(
                new StringStreamAdapter(OutputDataStream.sysOut())))))));

        eventStream.recordEvent(new Event("Refactula", "Created a weird event stream"));
        eventStream.recordEvent(new Event("Refactula", "Let's see how it works"));
        eventStream.recordEvent(new Event("Refactula", "It might support newlines\nor not"));
    }

    private static final class Event {
        private final String performedBy;
        private final String content;

        private Event(String performedBy, String content) {
            this.performedBy = performedBy;
            this.content = content;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("performedBy", performedBy)
                    .add("content", content)
                    .toString();
        }
    }

}
