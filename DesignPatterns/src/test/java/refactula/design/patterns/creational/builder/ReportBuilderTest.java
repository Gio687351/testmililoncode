package refactula.design.patterns.creational.builder;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReportBuilderTest {

    private UserStorage storage;

    @Before
    public void setup() {
        storage = new UserStorage(ImmutableList.of(
                new User(1, "John", "5115479427"),
                new User(2, "Ellie", "7541527032"),
                new User(4, "Catherine", "3229072321")));
    }

    @Test
    public void testXMLReport() {
        XMLReportBuilder reportBuilder = new XMLReportBuilder("report", "record", "value");
        storage.record(reportBuilder);
        String report = reportBuilder.generateReport();
        assertEquals("<report>" +
                "<record>" +
                "<value>1</value>" +
                "<value>John</value>" +
                "<value>5115479427</value>" +
                "</record>" +
                "<record>" +
                "<value>2</value>" +
                "<value>Ellie</value>" +
                "<value>7541527032</value>" +
                "</record>" +
                "<record>" +
                "<value>4</value>" +
                "<value>Catherine</value>" +
                "<value>3229072321</value>" +
                "</record>" +
                "</report>", report);
    }

    @Test
    public void testCSVReport() {
        TextReportBuilder reportBuilder = TextReportBuilder.commaSeparatedValues();
        storage.record(reportBuilder);
        String report = reportBuilder.toString();
        assertEquals("1,John,5115479427\n" +
                "2,Ellie,7541527032\n" +
                "4,Catherine,3229072321\n", report);
    }

    @Test
    public void testTSVReport() {
        TextReportBuilder reportBuilder = TextReportBuilder.tabSeparatedValues();
        storage.record(reportBuilder);
        String report = reportBuilder.toString();
        assertEquals("1\tJohn\t5115479427\n" +
                "2\tEllie\t7541527032\n" +
                "4\tCatherine\t3229072321\n", report);
    }

}