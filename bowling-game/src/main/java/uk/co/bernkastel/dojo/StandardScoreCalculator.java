package uk.co.bernkastel.dojo;

import java.util.List;

public class StandardScoreCalculator implements ScoreCalculator {
    private List<Frame> frameList;

    public StandardScoreCalculator(final List<Frame> frameList) {
        this.frameList = frameList;
    }

    @Override
    public int calculate() {
        return frameList.stream().mapToInt(Frame::getTotal).sum();
    }
}