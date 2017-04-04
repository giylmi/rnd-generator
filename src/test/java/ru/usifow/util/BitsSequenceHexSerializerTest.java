package ru.usifow.util;

import org.junit.Assert;
import org.junit.Test;
import ru.usifow.model.BitsSequence;

import static org.junit.Assert.*;

/**
 * Created by adel on 04.04.17.
 */
public class BitsSequenceHexSerializerTest {

    @Test
    public void serialize() throws Exception {
        Assert.assertEquals("8",
                new BitsSequenceHexSerializer().serialize(new BitsSequence("1000")));
        Assert.assertEquals("7",
                new BitsSequenceHexSerializer().serialize(new BitsSequence("111")));
        Assert.assertEquals("3F",
                new BitsSequenceHexSerializer().serialize(new BitsSequence("111111")));
        Assert.assertEquals("4EE",
                new BitsSequenceHexSerializer().serialize(new BitsSequence("10011101110")));
        Assert.assertEquals("0",
                new BitsSequenceHexSerializer().serialize(new BitsSequence("0")));
        Assert.assertEquals("1",
                new BitsSequenceHexSerializer().serialize(new BitsSequence("1")));
        Assert.assertEquals("10",
                new BitsSequenceHexSerializer().serialize(new BitsSequence("10000")));
        Assert.assertEquals("F",
                new BitsSequenceHexSerializer().serialize(new BitsSequence("1111")));
    }

}