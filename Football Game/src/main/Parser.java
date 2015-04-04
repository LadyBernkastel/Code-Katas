package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

	public FootballResults parse(String filename) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(filename));
		int lineCount = 0;
		try {
			String line = null;
			input.readLine();
			while ((line = input.readLine()) != null) {
				lineCount++;
				System.out.println(line);
			}
		} finally {
			input.close();
		}
		return new FootballResults(lineCount);

	}

}
