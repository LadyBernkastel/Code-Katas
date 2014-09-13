package weather;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WeatherData {
	
	private final File dataFile = new File("src/weather/weather.dat");

	public static void main(String[] args) {
		new WeatherData();
	}
	
	public WeatherData() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(dataFile);
			ArrayList<String> stringList = new ArrayList<String>();
			while (scanner.hasNextLine()) {
				stringList.add(scanner.nextLine());
			}
			
			int smallestSpread = -1;
			int spreadDate = 0;
			
			for (int i = 2; i < stringList.size(); i++) {
				String line = stringList.get(i);
				String[] splitLine = line.split("\\s+");
				int day = stringToInt(splitLine[1]);
				int max = stringToInt(splitLine[2]);
				int min = stringToInt(splitLine[3]);
				
				int spread = calculateTemperatureSpread(max, min);
				
				System.out.println("Day: " + day + " Max: " + max + " Min: " + min + " Spread: " + spread);
				
				if (smallestSpread == -1) {
					smallestSpread = spread;
				}
				
				if (spread < smallestSpread) {
					smallestSpread = spread;
					spreadDate = day;
				}
			}
			
			System.out.println("Smallest Spread: " + smallestSpread + " Day: " + spreadDate);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		
	}

	private int stringToInt(String stringToParse) {
		stringToParse = stringToParse.replaceAll( "[^\\d]", "" );
		try {
			return Integer.parseInt(stringToParse);
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	
	private int calculateTemperatureSpread(int max, int min) {
		return max - min;
	}
}
