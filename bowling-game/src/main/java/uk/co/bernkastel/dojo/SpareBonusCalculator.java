package uk.co.bernkastel.dojo;

import java.util.List;

public class SpareBonusCalculator implements ScoreCalculator {

    private List<Frame> frameList;

    public SpareBonusCalculator(List<Frame> frameList) {
        this.frameList = frameList;
    }

    @Override
    public int calculate() {
        boolean wasSpare = false;
        int bonus = 0;
        for (Frame frame : frameList) {
            if (wasSpare) {
                bonus += frame.getSpareBonus();
            }
            if (frame.isSpare()) {
                wasSpare = true;
            }
        }
        return bonus;
    }
}