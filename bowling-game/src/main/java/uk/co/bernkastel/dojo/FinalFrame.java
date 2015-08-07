package uk.co.bernkastel.dojo;

public class FinalFrame extends Frame {

    private int rollThree;

    public FinalFrame(int rollOne, int rollTwo, int rollThree) {
        super(rollOne, rollTwo);
        this.rollThree = rollThree;
    }

    @Override
    public int getTotal() {
        return rollOne == 10 ? rollOne : super.getTotal();
    }

    @Override
    public int getSpareBonus() {
        return rollThree;
    }

    @Override
    public int getStrikeBonus() {
        return rollTwo + rollThree;
    }

}
