package main;
import static org.junit.Assert.*;

import java.io.IOException;

import main.FootballResults;
import main.Parser;

import org.junit.Test;

public class ParserTest {
	
	@Test
	public void parsesCorrectNumberOfResults() throws IOException {
		Parser parser = new Parser();
		FootballResults footballResults = parser.parse("data/football.dat");
		assertEquals(footballResults.getNumberOfResults(), 20);
	}
	
}
