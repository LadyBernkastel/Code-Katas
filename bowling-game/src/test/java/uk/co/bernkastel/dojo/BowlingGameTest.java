package uk.co.bernkastel.dojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class BowlingGameTest {

    private BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGameFactory().create();
    }

    @Test
    public void gutterGame() throws Exception {
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertThat(game.score(), is(0));
    }

    @Test
    public void allOnes() throws Exception {
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertThat(game.score(), is(20));
    }

    @Test
    public void noSpares() throws Exception {
        game.roll(0);
        game.roll(0);
        game.roll(3);
        game.roll(0);
        game.roll(0);
        game.roll(0);
        game.roll(6);
        game.roll(2);
        game.roll(0);
        game.roll(2);
        game.roll(0);
        game.roll(0);
        game.roll(7);
        game.roll(1);
        game.roll(0);
        game.roll(5);
        game.roll(0);
        game.roll(0);
        game.roll(0);
        game.roll(0);
        assertThat(game.score(), is(26));
    }
}
