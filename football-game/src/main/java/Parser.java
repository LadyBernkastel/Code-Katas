import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

	public FootballResults parse(String filename) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(filename));
		FootballResults footballResults = new FootballResults();
		int lineCount = 0;
		try {
			String line = null;
			input.readLine();
			while ((line = input.readLine()) != null) {
				lineCount++;
				footballResults.addResult(line);
				System.out.println(line);
			}
		} finally {
			input.close();
		}
		footballResults.setNumberOfResults(lineCount);
		return footballResults;

	}

}
