package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utilities {

	public static int safeStringToInt(String stringToParse) {
		stringToParse = stringToParse.replaceAll("[^\\d]", "");
		try {
			return Integer.parseInt(stringToParse);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	public static List<String> parseFileIntoLines(File dataFile) {
		List<String> stringList = new ArrayList<String>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(dataFile);
			while (scanner.hasNextLine()) {
				stringList.add(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return stringList;
	}

	public static void getLineWithSmallestSpread(List<DataLine> dataLines) {
		int smallestSpread = -1;
		String subject = null;

		for (DataLine dataLine : dataLines) {
			if (smallestSpread == -1) {
				smallestSpread = dataLine.getSpread();
			}

			if (dataLine.getSpread() < smallestSpread) {
				smallestSpread = dataLine.getSpread();
				subject = dataLine.getSubject();
			}
		}

		System.out.println("Smallest spread - " + subject
				+ " with a spread of " + smallestSpread);
	}

	public static List<String[]> splitCleanStringsOnWhitespace(
			List<String> stringList) {
		ArrayList<String[]> splitStrings = new ArrayList<String[]>();

		for (int i = 1; i < stringList.size(); i++) {
			String[] splitLine = stringList.get(i).split("\\s+");
			if (splitLine.length > 10) {
				splitStrings.add(splitLine);
			}
		}

		return splitStrings;
	}

}
