import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TennisGame {
	private File gameFile;
	private Scanner scanner = null;

	private static final int GAME_POINT_LIMIT = 50;
	private int playerOneScore = 0;
	private int playerTwoScore = 0;
	private String winner = "";

	public TennisGame(File gameFile) {
		this.gameFile = gameFile;
	}

	public String playGame() {
		try {
			scanner = new Scanner(gameFile);
			while (!gameWon() && scanner.hasNextInt()) {
				playPoint();
				printScores();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return winner;
	}

	private boolean gameWon() {
		int scoreDiff = getScoreDifference();
		int totalScore = getTotalScore();
		
		if (gameHasReachedLimit()) {
			winner = "Draw";
			return true;
		}
		if (scoreDiff == 4 && totalScore == 4) {
			winner = "Player One";
			return true;
		}
		if (scoreDiff == -4 && totalScore == 4) {
			winner = "Player Two";
			return true;
		}
		if (gameHasReachedSixPoints()) {
			if (scoreDiff >= 2) {
				winner = "Player One";
				return true;
			}
			if (scoreDiff <= -2) {
				winner = "Player Two";
				return true;
			}
		}

		return false;
	}

	private boolean gameHasReachedSixPoints() {
		return getTotalScore() >= 6;
	}

	private boolean gameHasReachedLimit() {
		return getTotalScore() >= GAME_POINT_LIMIT;
	}

	private int getScoreDifference() {
		return playerOneScore - playerTwoScore;
	}

	private int getTotalScore() {
		return playerOneScore + playerTwoScore;
	}

	private void playPoint() {
		int point = scanner.nextInt();
		if (point == 1) {
			playerOneScore++;
		} else if (point == 2) {
			playerTwoScore++;
		}
	}

	private void printScores() {
		System.out.println("Player One: " + getStringScorePlayerOne()
				+ " - Player Two: " + getStringScorePlayerTwo());
	}

	private String getStringScorePlayerOne() {
		int scoreDiff = getScoreDifference();
		int totalScore = getTotalScore();
		
		if (totalScore >= 6) {
			switch (scoreDiff) {
			case -2: return "Point Lose";
			case -1: return "Disadvantage";
			case 0: return "Deuce";
			case 1: return "Advantage";
			case 2: return "Point Win";
			}
		} else if (scoreDiff <= 4) {
			switch (playerOneScore) {
			case 0: return "Love";
			case 1: return "15";
			case 2: return "30";
			case 3: return "40";
			case 4: return "Point Win";
			}
		}
		return "Unknown";
	}

	private String getStringScorePlayerTwo() {
		int scoreDiff = getScoreDifference();
		int totalScore = getTotalScore();
		
		if (totalScore >= 6) {
			switch (scoreDiff) {
			case 2: return "Point Lose";
			case 1: return "Disadvantage";
			case 0: return "Deuce";
			case -1: return "Advantage";
			case -2: return "Point Win";
			}
		} else if (scoreDiff <= 4) {
			switch (playerTwoScore) {
			case 0: return "Love";
			case 1: return "15";
			case 2: return "30";
			case 3: return "40";
			case 4: return "Point Win";
			}
		}
		return "Unknown";
	}
}
