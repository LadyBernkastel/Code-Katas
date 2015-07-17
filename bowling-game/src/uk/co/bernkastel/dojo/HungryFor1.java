package uk.co.bernkastel.dojo;


public class HungryFor1 implements State {

    private final Transition transition;

    public HungryFor1(Transition transition) {
        this.transition = transition;
    }

    @Override
    public void roll(Frame frame, int pins) {
        frame.addToScore(pins);
        transition.update(frame);
    }

}
