package uk.co.bernkastel.dojo;

import java.util.List;

public class FinalFrameSpareBonusCalculator implements ScoreCalculator {

    private List<Frame> frameList;

    public FinalFrameSpareBonusCalculator(List<Frame> frameList) {
        this.frameList = frameList;
    }

    @Override
    public int calculate() {
        Frame lastFrame = getLastFrame();
        return lastFrame.isSpare() ? lastFrame.getSpareBonus() : 0;
    }

    private Frame getLastFrame() {
        return frameList.get(frameList.size()-1);
    }
}
