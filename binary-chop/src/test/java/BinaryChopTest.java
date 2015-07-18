import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryChopTest {

    @Test
    public void testChop() {
        BinaryChop binaryChop = new BinaryChop();


        int[] emptyData = {};
        assertEquals(-1, binaryChop.chop(3, emptyData));
        int[] singleData = {1};
        assertEquals(-1, binaryChop.chop(3, singleData));
        assertEquals(0, binaryChop.chop(1, singleData));
        int[] threeData = {1, 3, 5};
        assertEquals(0, binaryChop.chop(1, threeData));
        assertEquals(1, binaryChop.chop(3, threeData));
        assertEquals(2, binaryChop.chop(5, threeData));
        assertEquals(-1, binaryChop.chop(0, threeData));
        assertEquals(-1, binaryChop.chop(2, threeData));
        assertEquals(-1, binaryChop.chop(4, threeData));
        assertEquals(-1, binaryChop.chop(6, threeData));
        int[] fourData = {1, 3, 5, 7};
        assertEquals(0, binaryChop.chop(1, fourData));
        assertEquals(1, binaryChop.chop(3, fourData));
        assertEquals(2, binaryChop.chop(5, fourData));
        assertEquals(3, binaryChop.chop(7, fourData));
        assertEquals(-1, binaryChop.chop(0, fourData));
        assertEquals(-1, binaryChop.chop(2, fourData));
        assertEquals(-1, binaryChop.chop(4, fourData));
        assertEquals(-1, binaryChop.chop(6, fourData));
        assertEquals(-1, binaryChop.chop(8, fourData));
    }

}