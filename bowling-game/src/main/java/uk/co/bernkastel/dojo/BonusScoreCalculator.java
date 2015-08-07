package uk.co.bernkastel.dojo;

import java.util.List;

public class BonusScoreCalculator implements ScoreCalculator {
    private List<Frame> frameList;

    public BonusScoreCalculator(List<Frame> frameList) {
        this.frameList = frameList;
    }

    @Override
    public int calculate() {
        return new SpareBonusCalculator(frameList).calculate();
    }
}
