
package uk.co.bernkastel.dojo;

public class ScoringFrame implements Frame {

    private final Frame next;
    private int score = 0;
    private State state;

    public ScoringFrame(Frame next, State initialState) {
        this.next = next;
        this.state = initialState;
    }

    @Override
    public int totalDownstreamScore() {
        return score + next.totalDownstreamScore();
    }

    @Override
    public void roll(int pins) {
        state.roll(this, pins);
    }

    @Override
    public void addToScore(int pins) {
        score += pins;
    }

    @Override
    public void passOn(int pins) {
        next.roll(pins);
    }

    @Override
    public void setState(State nextState) {
        state = nextState;
    }

    @Override
    public boolean allPinsDown() {
        return score == 10;
    }

}
