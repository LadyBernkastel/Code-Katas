package football;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FootballData {
	private final File dataFile = new File("src/football/football.dat");

	public static void main(String[] args) {
		new FootballData();
	}
	
	public FootballData() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(dataFile);
			ArrayList<String> stringList = new ArrayList<String>();
			while (scanner.hasNextLine()) {
				stringList.add(scanner.nextLine());
			}
			
			int smallestSpread = -1;
			String spreadTeam = null;
			
			for (int i = 1; i < stringList.size(); i++) {
				String[] splitLine = stringList.get(i).split("\\s+");
				
				if (splitLine.length == 11) {
					
					String team = splitLine[2];
					int goalsFor = stringToInt(splitLine[7]);
					int goalsAgainst = stringToInt(splitLine[9]);
					
					
					int spread = calculateGoalSpread(goalsFor, goalsAgainst);
					
					System.out.println("Team: " + team + " For: " + goalsFor + " Against: " + goalsAgainst + " Spread: " + spread);
	
					if (smallestSpread == -1) {
						smallestSpread = spread;
					}
					
					if (spread < smallestSpread) {
						smallestSpread = spread;
						spreadTeam = team;
					}
				
				}
			}

			System.out.println("Smallest Spread: " + smallestSpread + " Team: " + spreadTeam);
			
			
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
	
	private int calculateGoalSpread(int max, int min) {
		return Math.abs(max - min);
	}
}
