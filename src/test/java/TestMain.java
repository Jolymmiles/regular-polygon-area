import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public TestMain() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainFirst() {
        double expected = 72.69;
        String data = "5\n6.5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        RegularPolygon.main(null);
        double actual = Math.round(Double.parseDouble(outContent.toString()) * 100.0) / 100.0;
        assertEquals(expected, actual);
    }

    @Test
    public void testMainSecond() {
        String expected = "NO";
        String data = "2\n6.5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        RegularPolygon.main(null);
        String actual = outContent.toString().replaceAll("(\\r|\\n)", "");
        assertEquals(expected, actual);
    }

    @Test
    public void testMainThird() {
        String expected = "NO";
        String data = "5\n-2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        RegularPolygon.main(null);
        String actual = outContent.toString().replaceAll("(\\r|\\n)", "");
        assertEquals(expected, actual);
    }

}