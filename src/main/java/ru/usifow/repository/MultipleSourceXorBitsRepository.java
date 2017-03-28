package ru.usifow.repository;

import ru.usifow.model.BitsSequence;
import ru.usifow.source.Source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by adel on 28.03.17.
 */
public class MultipleSourceXorBitsRepository implements BitsRepository {

    private List<Source> sources;

    public MultipleSourceXorBitsRepository(Source first, Source... sources) {
        this.sources = new ArrayList<>();
        this.sources.add(first);
        this.sources.addAll(Arrays.asList(sources));
    }

    public MultipleSourceXorBitsRepository(List<Source> sources) {
        this.sources = sources;
    }

    @Override
    public BitsSequence getBitsSequence(short length) {
        BitsSequence seq = sources.get(0).getRandomBitsSequence(length);
        sources.stream().skip(1).forEach(source -> seq.xor(source.getRandomBitsSequence(length)));
        return seq;
    }
}
