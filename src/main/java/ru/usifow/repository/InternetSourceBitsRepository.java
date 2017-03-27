package ru.usifow.repository;

import ru.usifow.model.BitsSequence;
import ru.usifow.source.Source;

/**
 * Created by a.gilmullin on 21.03.2017.
 */
public class InternetSourceBitsRepository implements BitsRepository {

    public static int MAX_BUFFER_SIZE_BITS = 100 * 1024 * 8;
    private BitsSequence buffer;
    private Source source;

    public InternetSourceBitsRepository(Source source) {
        this.source = source;
        buffer = source.getRandomBitsSequence(MAX_BUFFER_SIZE_BITS);
    }

    @Override
    public synchronized BitsSequence getBitsSequence(short length) {
//        if (buffer.getBitsLength() >= length) {
//            return buffer.consumeLast(length);
//        }
//        else {
//            // need to load more
//            source.getRandomBitsSequence()
//        }
    }
}
