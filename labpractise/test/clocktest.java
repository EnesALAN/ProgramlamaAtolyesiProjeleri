import org.junit.Test;

import java.time.Clock;

import static org.junit.Assert.assertEquals;

public class clocktest {
    @Test
    public void name() {
        assertEquals("hi", "ho");
    }
    @Test
    public void testConstructor() {
        clock c = new clock(15,20,30);
        assertEquals(15, c.getHour());
        assertEquals(20, c.getMinutes());
        assertEquals(30, c.getSeconds());
    }
    @Test
    public void testTick() {
        clock c = new clock(15,20,59);
        c.tick();
        assertEquals(15, c.getHour());
        assertEquals(21, c.getMinutes());
        assertEquals(00, c.getSeconds());
    }

}