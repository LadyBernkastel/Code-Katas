package uk.co.bernkastel.dojo;

import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BonusScoreCalculatorTest {

    @Test
    public void calculatesSpareBonus() throws Exception {
        Frame spareFrame = new Frame(5, 5);
        Frame nextFrame = new Frame(2, 4);
        int calculatedBonus = new BonusScoreCalculator(newArrayList(spareFrame, nextFrame)).calculate();
        assertThat(calculatedBonus, is(2));
    }
}