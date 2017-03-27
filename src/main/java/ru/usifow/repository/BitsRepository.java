package ru.usifow.repository;

import ru.usifow.model.BitsSequence;

/**
 * Created by a.gilmullin on 21.03.2017.
 */
public interface BitsRepository {

    /*
        Returns sequence of `length` bits packed in array of bytes
     */
    BitsSequence getBitsSequence(short length);
}
