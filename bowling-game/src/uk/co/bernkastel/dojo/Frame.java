
package uk.co.bernkastel.dojo;

public interface Frame {

    public int totalDownstreamScore();

    public void roll(int pins);
    public void addToScore(int pins);


    public void passOn(int pins);

    public void setState(State nextState);

    public boolean allPinsDown();

}