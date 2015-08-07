package uk.co.bernkastel.dojo;

public class TotalScoreCalculator implements ScoreCalculator {

    private SpareBonusCalculator spareBonusCalculator;
    private ScoreCalculator scoreCalculator;

    public TotalScoreCalculator(final SpareBonusCalculator spareBonusCalculator, final ScoreCalculator scoreCalculator) {
        this.spareBonusCalculator = spareBonusCalculator;
        this.scoreCalculator = scoreCalculator;
    }

    @Override
    public int calculate() {
        return scoreCalculator.calculate() + spareBonusCalculator.calculate();
    }
}
