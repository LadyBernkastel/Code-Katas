package uk.co.bernkastel.dojo;


public class OneBonusBall implements State {

    @Override
    public void roll(Frame frame, int pins) {
        frame.addToScore(pins);
        frame.setState(new Complete());
        frame.passOn(pins);
    }

}
