package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

	public FootballResults parse(String filename) throws IOException {
		FootballResults footballResults = new FootballResults();
		BufferedReader input = new BufferedReader(new FileReader(filename));
		try {
			String line = null;
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
		} finally {
			input.close();
		}
		return footballResults;

	}

}
