import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FootballResultsTest {

	private static final String RESULT_INPUT = "    7. West_Ham        38    15   8  15    48  -  57    53";
	private Result result;
	private FootballResults footballResults;

	@Before
	public void before() {
		footballResults = new FootballResults();
		footballResults.addResult(RESULT_INPUT);
		result = footballResults.getResult(0);
	}
	
	@Test
	public void parsesTeamName() throws Exception {
		assertThat(result.getTeamName(), is("West_Ham"));
	}
	
	@Test
	public void returnsGoalDifference() throws Exception {
		assertThat(result.getGoalDifference(), is(9));
	}
	
	@Test
	public void returnsTeamWithHighestGoalDifference() throws IOException {
		footballResults = new Parser().parse("src/test/resources/football.dat");
		assertThat(footballResults.getTeamWithSmallestGoalDifference(), is("Aston_Villa"));
	}



}
