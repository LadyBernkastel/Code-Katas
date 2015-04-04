package main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;


public class ResultTest {

	@Test
	public void calculatesGoalDifference() throws Exception {
		Result result = new Result("TestTeam", 10, 5);
		assertThat(result .getGoalDifference(), is(5));
	}
	
	@Test
	public void calculatesGoalDifferenceWhenForGreaterThanAgainst() throws Exception {
		Result result = new Result("TestTeam", 5, 10);
		assertThat(result .getGoalDifference(), is(5));
	}
}
