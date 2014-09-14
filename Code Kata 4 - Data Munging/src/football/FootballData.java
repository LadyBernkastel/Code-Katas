package football;

import java.io.File;
import java.util.List;

import common.DataLine;
import common.Utilities;

public class FootballData {
	private final File dataFile = new File("src/football/football.dat");
	private static final int TEAM_COLUMN = 2;
	private static final int FOR_COLUMN = 7;
	private static final int AGAINST_COLUMN = 9;

	public static void main(String[] args) {
		new FootballData();
	}

	public FootballData() {
		List<String> stringList = Utilities.parseFileIntoLines(dataFile);
		List<String[]> splitStrings = Utilities.splitCleanStringsOnWhitespace(stringList);
		List<DataLine> dataLines = Utilities.convertStringsToDataLines(splitStrings,
				TEAM_COLUMN, FOR_COLUMN, AGAINST_COLUMN);
		Utilities.getLineWithSmallestSpread(dataLines);
	}
}
