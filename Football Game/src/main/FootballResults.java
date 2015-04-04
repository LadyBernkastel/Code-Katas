package main;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;

public class FootballResults {
	
	private int numberOfResults;
	private List<Result> results = new ArrayList<Result>();

	public int getNumberOfResults() {
		return numberOfResults;
	}

	public void setNumberOfResults(int numberOfResults) {
		this.numberOfResults = numberOfResults;
	}
	
	public Result getResult(int index) {
		return results.get(index);
	}

	public void addResult(String resultInput) {
		String[] splitLine = resultInput.split("\\s+");
		
		String teamName = splitLine[2];
		int forGoals = parseInt(splitLine[7]);
		int againstGoals = parseInt(splitLine[9]);
		
		results.add(new Result(teamName, forGoals, againstGoals));
	}
	
	public String getTeamWithSmallestGoalDifference() {
		int smallestDifference = Integer.MAX_VALUE;
		String teamWithSmallestDiff = "";
		
		for (Result team : results) {
			if (team.getGoalDifference() < smallestDifference) {
				smallestDifference = team.getGoalDifference();
				teamWithSmallestDiff = team.getTeamName();
			}
		}
		return teamWithSmallestDiff;
	}

}
