package ru.usifow.source;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by adel on 28.03.17.
 */
@RunWith(JUnit4.class)
public class HotBitsSourceTests {

    @Test
    public void getRandomBitsSequence() throws Exception {
        HotBitsSource source = new HotBitsSource();
        String print = source.getRandomBitsSequence(128).print();
        System.out.println("length: " + print.length());
        System.out.println(print);
        Assert.assertEquals(128, print.length());
    }
}
