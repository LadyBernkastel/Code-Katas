package uk.co.bernkastel.dojo;

import java.util.List;

public class TotalScoreCalculatorFactory {

    private List<Frame> frameList;

    public TotalScoreCalculatorFactory(List<Frame> frameList) {
        this.frameList = frameList;
    }

    public TotalScoreCalculator build() {
        return new TotalScoreCalculator(new SpareBonusCalculator(frameList), new StandardScoreCalculator(frameList), new FinalFrameSpareBonusCalculator(frameList), new StrikeBonusCalculator(frameList));
    }
}
