
package uk.co.bernkastel.dojo;

public class Transition {

    private final State stateForNotBonus;
    private final State stateForBonus;

    public Transition(State stateForBonus, State stateForNotBonus) {
        this.stateForBonus = stateForBonus;
        this.stateForNotBonus = stateForNotBonus;
    }

    public void update(Frame frame) {
        if (frame.allPinsDown()) {
            frame.setState(stateForBonus);
        } else {
            frame.setState(stateForNotBonus);
        }
    }

}
