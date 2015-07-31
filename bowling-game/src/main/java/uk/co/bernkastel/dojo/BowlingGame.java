package uk.co.bernkastel.dojo;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	private List<Integer> frameList;

	public BowlingGame() {
		frameList = new ArrayList<Integer>();
	}

	public void roll(int roll) {
		frameList.add(roll);
	}
	
	public int score() {
		return new ScoreCaluclatorFactory(frameList).build().score();
	}
	
}
