package uk.co.bernkastel.dojo;

import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StandardScoreCalculatorTest {

    @Test
    public void calculatesStandardScore() throws Exception {
        Frame frameOne = new Frame(1, 2);
        Frame frameTwo = new Frame(3, 4);
        int calculatedScore = new StandardScoreCalculator(newArrayList(frameOne, frameTwo)).calculate();
        assertThat(calculatedScore, is(10));
    }
}