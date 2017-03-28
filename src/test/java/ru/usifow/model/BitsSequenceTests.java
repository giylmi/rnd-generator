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

    @Test
    public void testSetBit() {
        BitsSequence sequence = new BitsSequence(1);
        sequence.addBit((byte) 0);
        sequence.addBit((byte) 1);
        sequence.addBit((byte) 0);
        sequence.addBit((byte) 1);

        sequence.setBit(0, (byte) 0);
        Assert.assertEquals("0101", sequence.print());
        sequence.setBit(0, (byte) 1);
        Assert.assertEquals("1101", sequence.print());
    }

    @Test
    public void testXor() {
        BitsSequence sequence1 = new BitsSequence("0101");
        BitsSequence sequence2 = new BitsSequence("1101");

        Assert.assertEquals("1000", sequence1.xor(sequence2).print());
    }
}
