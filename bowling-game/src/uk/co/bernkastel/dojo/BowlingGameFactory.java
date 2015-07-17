package uk.co.bernkastel.dojo;


public class BowlingGameFactory {

    public BowlingGame create() {
        return new BowlingScorecard(createFrames());
    }

    private Frame createFrames() {
        Frame frame = createEndStop();
        for (int i = 0; i < 10; i++) {
            frame = createFrame(frame);
        }
        return frame;
    }

    public ScoringFrame createFrame(Frame next) {
        Transition spareBonus = new Transition(new OneBonusBall(), new Complete());
        Transition strikeBonus = new Transition(new TwoBonusBalls(), new HungryFor1(spareBonus));
        HungryFor2 initialState = new HungryFor2(strikeBonus);
        return new ScoringFrame(next, initialState);
    }

    public Frame createEndStop() {
        Frame frame = new Frame() {
            @Override
            public int totalDownstreamScore() { return 0; }
            @Override
            public void roll(int pins) { }
            @Override
            public void addToScore(int pins) { }
            @Override
            public void passOn(int pins) { }
            @Override
            public void setState(State nextState) { }
            @Override
            public boolean allPinsDown() {
                return false;
            }
        };
        return frame;
    }

}
