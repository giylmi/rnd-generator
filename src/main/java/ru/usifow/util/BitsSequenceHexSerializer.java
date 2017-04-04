package ru.usifow.util;

import ru.usifow.model.BitsSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adel on 04.04.17.
 */
public class BitsSequenceHexSerializer {

    public String serialize(BitsSequence sequence) {
        String res = "";
        int decimal = 0;
        for (int i = 0; i < sequence.getBitsLength(); ++i) {
            decimal += sequence.getBit(i) << (i % 15);
            if ((i + 1) % 15 == 0) {
                res = Integer.toHexString(decimal) + res;
                decimal = 0;
            }
        }
        if (sequence.getBitsLength() % 15 != 0) {
            res = Integer.toHexString(decimal) + res;
        }
        return res.toUpperCase();
    }
}
