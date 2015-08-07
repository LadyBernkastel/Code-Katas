package uk.co.bernkastel.dojo;

import java.util.List;

public class FinalFrameStrikeBonusCalculator implements ScoreCalculator {
    private List<Frame> frameList;

    public FinalFrameStrikeBonusCalculator(List<Frame> frameList) {
        this.frameList = frameList;
    }

    @Override
    public int calculate() {
        Frame lastFrame = getLastFrame();
        return lastFrame.isStrike() ? lastFrame.getStrikeBonus() : 0;
    }

    private Frame getLastFrame() {
        return frameList.get(frameList.size()-1);
    }
}
