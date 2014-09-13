package football;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import common.DataLine;
import common.Utilities;

public class FootballData {
	private final File dataFile = new File("src/football/football.dat");

	public static void main(String[] args) {
		new FootballData();
	}

	public FootballData() {
		List<String> stringList = Utilities.parseFileIntoLines(dataFile);
		List<DataLine> dataLines = new ArrayList<DataLine>();

		for (int i = 1; i < stringList.size(); i++) {
			String[] splitLine = stringList.get(i).split("\\s+");

			if (splitLine.length == 11) {

				String team = splitLine[2];
				int goalsFor = Utilities.safeStringToInt(splitLine[7]);
				int goalsAgainst = Utilities.safeStringToInt(splitLine[9]);
				
				dataLines.add(new DataLine(team, goalsFor, goalsAgainst));
			}
		}
		
		Utilities.getLineWithSmallestSpread(dataLines);

	}
}
