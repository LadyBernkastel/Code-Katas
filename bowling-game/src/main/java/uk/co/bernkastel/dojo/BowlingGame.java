package uk.co.bernkastel.dojo;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	private List<Frame> frameList;

	public BowlingGame() {
		frameList = new ArrayList<Frame>();
	}

	public void frame(int rollOne, int rollTwo) {
		frameList.add(new Frame(rollOne, rollTwo));
	}
	
	public int score() {
		return new TotalScoreCalculatorFactory(frameList).build().calculate();
	}

	public void finalFrame(int rollOne, int rollTwo, int rollThree) {
		frameList.add(new FinalFrame(rollOne, rollTwo, rollThree));
	}
}
