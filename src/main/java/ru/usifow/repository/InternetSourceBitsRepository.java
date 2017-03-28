package ru.usifow.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.usifow.model.BitsSequence;
import ru.usifow.source.Source;

/**
 * Created by a.gilmullin on 21.03.2017.
 */
@Repository
public class InternetSourceBitsRepository implements BitsRepository {

    private Logger logger = LoggerFactory.getLogger(InternetSourceBitsRepository.class);

    public static int MAX_BUFFER_SIZE_BITS = 100 * 1024 * 8;
//    private final BitsSequence buffer;
    private Source source;
    private String name;

    public InternetSourceBitsRepository(String name, Source source) {
        this.name = name;
        this.source = source;
        logger.info("uploading buffer for " + name + " source");
//        buffer = source.getRandomBitsSequence(MAX_BUFFER_SIZE_BITS);
    }

    @Override
    public synchronized BitsSequence getBitsSequence(short length) {
        return source.getRandomBitsSequence(length);
    }
}
