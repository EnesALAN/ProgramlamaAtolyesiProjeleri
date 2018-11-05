package ocr;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecognizerTest {
    @Test
    public void testDigit0() {
        Recognizer recognizer = new Recognizer();
        String input = String.join("\n",
                " _ ",
                "| |",
                "|_|",
                "   ");

        String output = recognizer.convert(input);
        assertEquals("0", output);
    }

    @Test
    public void test123() {
        Recognizer recognizer = new Recognizer();
        String input = String.join("\n",
                "    _  _ ",
                "  | _| _|",
                "  ||_  _|",
                "         ");

        String output = recognizer.convert(input);
        assertEquals("123", output);
    }

    @Test
    public void test1_3() {
        Recognizer recognizer = new Recognizer();
        String input = String.join("\n",
                "    _  _ ",
                "  ||_| _|",
                "  ||_  _|",
                "         ");

        String output = recognizer.convert(input);
        assertEquals("1?3", output);
    }
}
