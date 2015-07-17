package uk.co.bernkastel.dojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;


public class BowlingGameTest {

	@Test
	public void gutterGame() throws Exception {
		BowlingGame game = new BowlingGameFactory().create();
		for (int i = 0; i < 1; i++) {
			game.roll(0);
		}
		assertThat(game.score(), is(0));
	}
	
}
