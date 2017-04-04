package ru.usifow.util;

import org.junit.Assert;
import org.junit.Test;
import ru.usifow.model.BitsSequence;

import static org.junit.Assert.*;

/**
 * Created by adel on 04.04.17.
 */
public class BitsSequenceBase64SerializerTest {
    @Test
    public void serialize() throws Exception {
        Assert.assertEquals("OA==",
                new BitsSequenceBase64Serializer().serialize(new BitsSequence("1000")));
        Assert.assertEquals("Nw==",
                new BitsSequenceBase64Serializer().serialize(new BitsSequence("111")));
        Assert.assertEquals("M0Y=",
                new BitsSequenceBase64Serializer().serialize(new BitsSequence("111111")));
        Assert.assertEquals("NEVF",
                new BitsSequenceBase64Serializer().serialize(new BitsSequence("10011101110")));
        Assert.assertEquals("MA==",
                new BitsSequenceBase64Serializer().serialize(new BitsSequence("0")));
        Assert.assertEquals("MQ==",
                new BitsSequenceBase64Serializer().serialize(new BitsSequence("1")));
        Assert.assertEquals("MTA=",
                new BitsSequenceBase64Serializer().serialize(new BitsSequence("10000")));
        Assert.assertEquals("Rg==",
                new BitsSequenceBase64Serializer().serialize(new BitsSequence("1111")));
    }

}