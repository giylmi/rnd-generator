package ru.usifow.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by a.gilmullin on 22.03.2017.
 */
@RunWith(JUnit4.class)
public class BitsSequenceTests {

    @Test
    public void testAddBit() {
        BitsSequence sequence = new BitsSequence(1);
        sequence.addBit((byte) 0);
        sequence.addBit((byte) 1);
        sequence.addBit((byte) 0);
        sequence.addBit((byte) 1);

        Assert.assertEquals("0101", sequence.print());
    }

    @Test
    public void testFromString() {
        BitsSequence sequence = new BitsSequence("1111000001101011101");

        Assert.assertEquals("1111000001101011101", sequence.print());
    }
}
