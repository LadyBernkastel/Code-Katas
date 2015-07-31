package uk.co.bernkastel.dojo;

import java.util.List;

public class ScoreCalculator {

    private List<Frame> frameList;

    public ScoreCalculator(List<Frame> frameList) {
        this.frameList = frameList;
    }

    public int score() {
        int standardScore = frameList.stream().mapToInt(Frame::getTotal).sum();
        int bonusScore = new BonusScoreCalculator(frameList).calculate();
        return standardScore + bonusScore;
    }
}
