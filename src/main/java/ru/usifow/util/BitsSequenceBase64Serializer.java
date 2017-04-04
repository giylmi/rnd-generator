package ru.usifow.util;

import ru.usifow.model.BitsSequence;

import java.util.Base64;

/**
 * Created by adel on 04.04.17.
 */
public class BitsSequenceBase64Serializer {

    public String serialize(BitsSequence sequence) {
        return Base64.getEncoder().encodeToString(new BitsSequenceHexSerializer().serialize(sequence).getBytes());
    }
}
