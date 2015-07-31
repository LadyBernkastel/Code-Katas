package uk.co.bernkastel.dojo;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	private List<Integer> frameList;

	public BowlingGame() {
		frameList = new ArrayList<Integer>();
	}

	public void frame(int rollOne, int rollTwo) {
		frameList.add(rollOne);
		frameList.add(rollTwo);
	}
	
	public int score() {
		return new ScoreCaluclatorFactory(frameList).build().score();
	}
	
}
