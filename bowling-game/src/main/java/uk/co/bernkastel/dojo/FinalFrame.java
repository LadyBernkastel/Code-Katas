package uk.co.bernkastel.dojo;

public class FinalFrame extends Frame {

    private int rollThree;

    public FinalFrame(int rollOne, int rollTwo, int rollThree) {
        super(rollOne, rollTwo);
        this.rollThree = rollThree;
    }

    @Override
    public int getSpareBonus() {
        return rollThree;
    }

}
