import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryChopTest {
    private BinaryChop chop;

    @Before
    public void setUp() throws Exception {
        chop = new BinaryChop();
    }

    @Test
    public void emptyDataTest() throws Exception {
        int[] emptyData = {};
        assertEquals(-1, chop.iterativeChop(3, emptyData));
        assertEquals(-1, chop.recursiveChop(3, emptyData));
    }

    @Test
    public void singleDataTest() throws Exception {
        int[] singleData = {1};
        assertEquals(-1, chop.iterativeChop(3, singleData));
        assertEquals(0, chop.iterativeChop(1, singleData));

        assertEquals(-1, chop.recursiveChop(3, singleData));
        assertEquals(0, chop.recursiveChop(1, singleData));
    }

    @Test
    public void threeDataTest() throws Exception {
        int[] threeData = {1, 3, 5};
        assertEquals(0, chop.iterativeChop(1, threeData));
        assertEquals(1, chop.iterativeChop(3, threeData));
        assertEquals(2, chop.iterativeChop(5, threeData));
        assertEquals(-1, chop.iterativeChop(0, threeData));
        assertEquals(-1, chop.iterativeChop(2, threeData));
        assertEquals(-1, chop.iterativeChop(4, threeData));
        assertEquals(-1, chop.iterativeChop(6, threeData));

        assertEquals(0, chop.recursiveChop(1, threeData));
        assertEquals(1, chop.recursiveChop(3, threeData));
        assertEquals(2, chop.recursiveChop(5, threeData));
        assertEquals(-1, chop.recursiveChop(0, threeData));
        assertEquals(-1, chop.recursiveChop(2, threeData));
        assertEquals(-1, chop.recursiveChop(4, threeData));
        assertEquals(-1, chop.recursiveChop(6, threeData));
    }

    @Test
    public void fourDataTest() {
        int[] fourData = {1, 3, 5, 7};
        assertEquals(0, chop.iterativeChop(1, fourData));
        assertEquals(1, chop.iterativeChop(3, fourData));
        assertEquals(2, chop.iterativeChop(5, fourData));
        assertEquals(3, chop.iterativeChop(7, fourData));
        assertEquals(-1, chop.iterativeChop(0, fourData));
        assertEquals(-1, chop.iterativeChop(2, fourData));
        assertEquals(-1, chop.iterativeChop(4, fourData));
        assertEquals(-1, chop.iterativeChop(6, fourData));
        assertEquals(-1, chop.iterativeChop(8, fourData));

        assertEquals(0, chop.recursiveChop(1, fourData));
        assertEquals(1, chop.recursiveChop(3, fourData));
        assertEquals(2, chop.recursiveChop(5, fourData));
        assertEquals(3, chop.recursiveChop(7, fourData));
        assertEquals(-1, chop.recursiveChop(0, fourData));
        assertEquals(-1, chop.recursiveChop(2, fourData));
        assertEquals(-1, chop.recursiveChop(4, fourData));
        assertEquals(-1, chop.recursiveChop(6, fourData));
        assertEquals(-1, chop.recursiveChop(8, fourData));
    }

}