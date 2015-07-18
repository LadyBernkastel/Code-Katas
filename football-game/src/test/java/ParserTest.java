import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ParserTest {
	
	private Parser parser;
	private FootballResults footballResults;

	@Before
	public void before() throws IOException {
		parser = new Parser();
		footballResults = parser.parse("src/test/resources/football.dat");
	}
	
	@Test
	public void parsesCorrectNumberOfResults() {
		assertThat(footballResults.getNumberOfResults(), is(20));
	}
	
}
