package uk.co.bernkastel.dojo;


public class Complete implements State {

    @Override
    public void roll(Frame frame, int pins) {
        frame.passOn(pins);
    }

}
