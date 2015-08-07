package uk.co.bernkastel.dojo;

import java.util.List;

public class ScoreCalculatorFactory {

    private List<Frame> frameList;

    public ScoreCalculatorFactory(List<Frame> frameList) {
        this.frameList = frameList;
    }

    public TotalScoreCalculator build() {
        return new TotalScoreCalculator(new SpareBonusCalculator(frameList), new StandardScoreCalculator(frameList));
    }
}
