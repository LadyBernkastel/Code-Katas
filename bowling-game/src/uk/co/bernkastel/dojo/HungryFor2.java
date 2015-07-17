package uk.co.bernkastel.dojo;


public class HungryFor2 implements State {

    private final Transition transition;

    public HungryFor2(Transition transition) {
        this.transition = transition;
    }

    @Override
    public void roll(Frame frame, int pins) {
        frame.addToScore(pins);
        transition.update(frame);
    }

}
