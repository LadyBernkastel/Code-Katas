package uk.co.bernkastel.dojo;

public class Frame {
    private final int rollOne;
    private final int rollTwo;

    public Frame(int rollOne, int rollTwo) {
        this.rollOne = rollOne;
        this.rollTwo = rollTwo;
    }

    public int getTotal() {
        return rollOne + rollTwo;
    }

    public boolean isSpare() {
        return getTotal() == 10 && (rollOneIsSpare() || rollTwoIsSpare());
    }

    public int getSpareBonus() {
        return rollOne;
    }

    private boolean rollTwoIsSpare() {
        return rollTwo < 10 && rollOne != 10;
    }

    private boolean rollOneIsSpare() {
        return rollOne < 10 && rollTwo != 10;
    }

    public int getStrikeBonus() {
        return rollOne + rollTwo;
    }

    public boolean isStrike() {
        return rollOne == 10;
    }
}
