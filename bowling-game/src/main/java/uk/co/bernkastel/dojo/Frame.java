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
        return false;
    }
}
