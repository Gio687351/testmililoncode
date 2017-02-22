package refactula.design.patterns.structural.bridge;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import refactula.design.patterns.structural.bridge.data_stream.FileDataStream;
import refactula.design.patterns.structural.bridge.data_stream.OutputDataStream;
import refactula.design.patterns.structural.bridge.event_stream.AsyncEventStream;
import refactula.design.patterns.structural.bridge.event_stream.SimpleEventStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;

public class EventStreamIntegrationTest {

    @Test
    public void testAsyncFileEventStream() throws IOException {
        Path tempFile = Files.createTempFile("event-stream", ".txt");
        AsyncEventStream eventStream = new AsyncEventStream(new FileDataStream(tempFile));
        eventStream.recordEvent("First event\n");
        eventStream.recordEvent("Second event\n");
        eventStream.recordEvent("Third event\n");
        assertEquals(ImmutableList.of(), Files.readAllLines(tempFile, StandardCharsets.UTF_8));
        eventStream.flush();
        assertEquals(ImmutableList.of("First event", "Second event", "Third event"),
                Files.readAllLines(tempFile, StandardCharsets.UTF_8));
    }

    @Test
    public void testSimpleFileEventStream() throws IOException {
        Path tempFile = Files.createTempFile("event-stream", ".txt");
        EventStream eventStream = new SimpleEventStream(new FileDataStream(tempFile));

        eventStream.recordEvent("First event\n");
        assertEquals(ImmutableList.of("First event"),
                Files.readAllLines(tempFile, StandardCharsets.UTF_8));

        eventStream.recordEvent("Second event\n");
        assertEquals(ImmutableList.of("First event", "Second event"),
                Files.readAllLines(tempFile, StandardCharsets.UTF_8));

        eventStream.recordEvent("Third event\n");
        assertEquals(ImmutableList.of("First event", "Second event", "Third event"),
                Files.readAllLines(tempFile, StandardCharsets.UTF_8));
    }

    @Test
    public void testAsyncOutputEventStream() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        AsyncEventStream eventStream = new AsyncEventStream(new OutputDataStream(buffer));
        eventStream.recordEvent("First event\n");
        eventStream.recordEvent("Second event\n");
        eventStream.recordEvent("Third event\n");
        assertEquals("", new String(buffer.toByteArray(), StandardCharsets.UTF_8));
        eventStream.flush();
        assertEquals("First event\nSecond event\nThird event\n",
                new String(buffer.toByteArray(), StandardCharsets.UTF_8));
    }

    @Test
    public void testSimpleOutputEventStream() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        EventStream eventStream = new SimpleEventStream(new OutputDataStream(buffer));

        eventStream.recordEvent("First event\n");
        assertEquals("First event\n",
                new String(buffer.toByteArray(), StandardCharsets.UTF_8));

        eventStream.recordEvent("Second event\n");
        assertEquals("First event\nSecond event\n",
                new String(buffer.toByteArray(), StandardCharsets.UTF_8));

        eventStream.recordEvent("Third event\n");
        assertEquals("First event\nSecond event\nThird event\n",
                new String(buffer.toByteArray(), StandardCharsets.UTF_8));
    }

}