package uk.co.bernkastel.dojo;

import java.util.List;

public class StrikeBonusCalculator implements ScoreCalculator {

    private List<Frame> frameList;

    public StrikeBonusCalculator(List<Frame> frameList) {
        this.frameList = frameList;
    }

    @Override
    public int calculate() {
        boolean wasStrike = false;
        int bonus = 0;
        for (Frame frame : frameList) {
            if (wasStrike) {
                bonus += frame.getStrikeBonus();
            }
            if (frame.isStrike()) {
                wasStrike = true;
            }
        }
        return bonus;
    }
}
