package refactula.design.patterns.structural.bridge.app;

import refactula.design.patterns.structural.bridge.EventStream;
import refactula.design.patterns.structural.bridge.data_stream.OutputDataStream;
import refactula.design.patterns.structural.bridge.event_stream.AsyncEventStream;
import refactula.design.patterns.structural.bridge.event_stream.SimpleEventStream;

public class ExampleApp {

    public static void main(String[] args) {
        SimpleEventStream simpleEventStream = new SimpleEventStream(OutputDataStream.systemOut());
        recordTestData("simple event stream", simpleEventStream);

        AsyncEventStream asyncEventStream = new AsyncEventStream(OutputDataStream.systemOut());
        recordTestData("async event stream", asyncEventStream);

        infoLog("Flushing async event stream...");
        asyncEventStream.flush();
    }

    private static void recordTestData(String name, EventStream eventStream) {
        infoLog("Recording test data for " + name + "...");
        record(eventStream, "First event\n");
        record(eventStream, "Second event\n");
        record(eventStream, "Third event\n");
        infoLog("Finished.\n");
    }

    private static void record(EventStream eventStream, String event) {
        infoLog("Recording event \"" + event.replaceAll("\n", "") + "\"...");
        eventStream.recordEvent(event);
    }

    private static void infoLog(String s) {
        System.out.println("> " + s);
    }

}
