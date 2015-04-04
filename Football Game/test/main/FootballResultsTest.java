package main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class FootballResultsTest {

	private static final String RESULT_INPUT = "    7. West_Ham        38    15   8  15    48  -  57    53";
	private Result result;

	@Before
	public void before() {
		FootballResults footballResults = new FootballResults();
		footballResults.addResult(RESULT_INPUT);
		result = footballResults.getResult(0);
	}
	
	@Test
	public void parsesTeamName() throws Exception {
		assertThat(result.getTeamName(), is("West_Ham"));
	}

}
