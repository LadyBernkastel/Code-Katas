package uk.co.bernkastel.dojo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class BowlingGameTest {

    private BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGameFactory().create();
    }

    @Test
    public void gutterGame() throws Exception {
        for (int i = 0; i < 10; i++) {
            game.frame(0, 0);
        }
        assertThat(game.score(), is(0));
    }

    @Test
    public void allOnes() throws Exception {
        for (int i = 0; i < 10; i++) {
            game.frame(1, 1);
        }
        assertThat(game.score(), is(20));
    }

    @Test
    public void noSpares() throws Exception {
        game.frame(0, 0);
        game.frame(3, 0);
        game.frame(0, 0);
        game.frame(6, 2);
        game.frame(0, 2);
        game.frame(0, 0);
        game.frame(7, 1);
        game.frame(0, 5);
        game.frame(0, 0);
        game.frame(0, 0);
        assertThat(game.score(), is(26));
    }

    @Test
    public void oneSpare() throws Exception {
        game.frame(0, 1);
        game.frame(7, 2);
        game.frame(3, 7);
        game.frame(7, 1);
        game.frame(0, 0);
        game.frame(0, 0);
        game.frame(0, 0);
        game.frame(0, 0);
        game.frame(0, 0);
        game.frame(0, 0);
        assertThat(game.score(), is(35));
    }
}
