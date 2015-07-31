package uk.co.bernkastel.dojo;

import java.util.List;

public class ScoreCalculator {

    private List<Integer> frameList;

    public ScoreCalculator(List<Integer> frameList) {
        this.frameList = frameList;
    }

    public int score() {
        return frameList.stream().reduce(0, (a, b) -> a + b);
    }
}
