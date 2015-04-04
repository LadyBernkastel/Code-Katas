package main;

public class Result {

	private String teamName;
	private int forGoals;
	private int againstGoals;

	public Result(String teamName, int forGoals, int againstGoals) {
		this.teamName = teamName;	
		this.forGoals = forGoals;
		this.againstGoals = againstGoals;
	}

	public String getTeamName() {
		return teamName;
	}

	public int getGoalDifference() {
		return Math.abs(forGoals - againstGoals);
	}

}
