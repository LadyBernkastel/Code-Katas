package uk.co.bernkastel.dojo;

import java.util.List;

public class ScoreCaluclatorFactory {

    private List<Integer> frameList;

    public ScoreCaluclatorFactory(List<Integer> frameList) {
        this.frameList = frameList;
    }

    public ScoreCalculator build() {
        return new ScoreCalculator(frameList);
    }
}
