package uk.co.bernkastel.dojo;

import junit.framework.TestCase;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FrameTest extends TestCase {

    public void testRollOneSpare() throws Exception {
        assertThat(new Frame(7, 3).isSpare(), is(true));
    }

    public void testRollTwoSpare() throws Exception {
        assertThat(new Frame(3, 7).isSpare(), is(true));
    }

    public void testRollOneIsNotSpare() throws Exception {
        assertThat(new Frame(1, 5).isSpare(), is(false));
    }

    public void testRollTwoIsNotSpare() throws Exception {
        assertThat(new Frame(5, 1).isSpare(), is(false));
    }

    public void testStrikeIsNotSpare() throws Exception {
        assertThat(new Frame(10, 0).isSpare(), is(false));
    }

    public void testGutterIsNotSpare() throws Exception {
        assertThat(new Frame(0, 0).isSpare(), is(false));
    }
}