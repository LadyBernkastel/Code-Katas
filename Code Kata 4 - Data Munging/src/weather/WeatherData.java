package weather;

import java.io.File;
import java.util.List;

import common.DataLine;
import common.Utilities;

public class WeatherData {
	private static final int DAY_COLUMN = 1;
	private static final int MAX_COLUMN = 2;
	private static final int MIN_COLUMN = 3;
	private final File dataFile = new File("src/weather/weather.dat");

	public static void main(String[] args) {
		new WeatherData();
	}

	public WeatherData() {
		List<String> stringList = Utilities.parseFileIntoLines(dataFile);
		List<String[]> splitStrings = Utilities.splitCleanStringsOnWhitespace(stringList);
		List<DataLine> dataLines = Utilities.convertStringsToDataLines(splitStrings,
				DAY_COLUMN, MAX_COLUMN, MIN_COLUMN);
		Utilities.getLineWithSmallestSpread(dataLines);
	}
}
