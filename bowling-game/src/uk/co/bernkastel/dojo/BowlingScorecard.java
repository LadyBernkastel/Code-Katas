package uk.co.bernkastel.dojo;


public class BowlingScorecard implements BowlingGame {

    private final Frame frames;

    public BowlingScorecard(Frame frames) {
        this.frames = frames;
    }

    @Override
    public void roll(int pins) {
        frames.roll(pins);
    }

    @Override
    public int score() {
        return frames.totalDownstreamScore();
    }

}
