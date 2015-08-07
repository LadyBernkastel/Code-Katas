package uk.co.bernkastel.dojo;

import static java.util.Arrays.stream;

public class TotalScoreCalculator implements ScoreCalculator {

    private ScoreCalculator[] scoreCalculators;

    public TotalScoreCalculator(ScoreCalculator... scoreCalculators) {
        this.scoreCalculators = scoreCalculators;
    }

    @Override
    public int calculate() {
        return stream(scoreCalculators).mapToInt(ScoreCalculator::calculate).sum();
    }
}
