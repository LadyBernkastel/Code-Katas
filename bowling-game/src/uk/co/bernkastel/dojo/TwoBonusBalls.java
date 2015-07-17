package uk.co.bernkastel.dojo;


public class TwoBonusBalls implements State {

    @Override
    public void roll(Frame frame, int pins) {
        frame.addToScore(pins);
        frame.setState(new OneBonusBall());
        frame.passOn(pins);
    }

}
