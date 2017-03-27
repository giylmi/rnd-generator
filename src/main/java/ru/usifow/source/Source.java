package ru.usifow.source;

import ru.usifow.model.BitsSequence;

/**
 * Created by a.gilmullin on 21.03.2017.
 */
public interface Source {

    BitsSequence getRandomBitsSequence(int length);
}
