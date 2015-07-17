package uk.co.bernkastel.dojo;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class BowlingGameTest {

    private BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGameFactory().create();
    }

    private void roll(int[] rolls) {
        for (int roll : rolls) {
            game.roll(roll);
        }
    }

    @Test
    public void gutterGame() {
        roll(new int[]{0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0});
        assertEquals(0, game.score());
    }

    @Test
    public void allOnes() {
        roll(new int[]{1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1});
        assertEquals(20, game.score());
    }

    @Test
    public void notASpare() {
        roll(new int[]{0,0, 0,0, 0,4, 6,2, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0});
        assertEquals(12, game.score());
    }

    @Test
    public void spare() {
        roll(new int[]{0,0, 0,0, 6,4, 6,2, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0});
        assertEquals(24, game.score());
    }

    @Test
    public void spareInTheLastFrame() {
        roll(new int[]{0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 4,6,3});
        assertEquals(13, game.score());
    }

    @Test
    public void strike() {
        roll(new int[]{0,0, 0,0, 10, 6,2, 5,0, 0,0, 0,0, 0,0, 0,0, 0,0});
        assertEquals(31, game.score());
    }

    @Test
    public void perfectGame() {
        roll(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10,10,10});
        assertEquals(300, game.score());
    }

}
