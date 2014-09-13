package weather;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import common.DataLine;
import common.Utilities;

public class WeatherData {
	private final File dataFile = new File("src/weather/weather.dat");

	public static void main(String[] args) {
		new WeatherData();
	}

	public WeatherData() {
		List<String> stringList = Utilities.parseFileIntoLines(dataFile);
		List<DataLine> dataLines = new ArrayList<DataLine>();

		for (int i = 2; i < stringList.size(); i++) {
			String[] splitLine = stringList.get(i).split("\\s+");
			
			String day = splitLine[1];
			int max = Utilities.safeStringToInt(splitLine[2]);
			int min = Utilities.safeStringToInt(splitLine[3]);
			
			dataLines.add(new DataLine(day, max, min));
		}
		
		Utilities.getLineWithSmallestSpread(dataLines);
	}
}
