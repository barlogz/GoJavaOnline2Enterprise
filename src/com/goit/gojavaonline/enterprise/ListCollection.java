package com.goit.gojavaonline.enterprise;

import java.util.List;
import java.util.Map;

public class ListCollection extends CollectionsForTesting {
    public ListCollection(int collectionSize, List<Integer> list) {
        this.collection = list;
        this.collectionSize = collectionSize;
        this.populate(0, Integer.MAX_VALUE, 1);
    }

    @Override
    public long add(int numberOfMeasurements) {
        final long startTime = System.nanoTime();

        for (int i = 0; i < numberOfMeasurements; i++) {
            ((List<Integer>) collection).add(randomIntGenerator(0, collection.size() - 1), i);
        }

        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / numberOfMeasurements;
    }

    @Override
    public long get(int numberOfMeasurements) {
        final long startTime = System.nanoTime();

        for (int i = 0; i < numberOfMeasurements; i++) {
            ((List<Integer>) collection).get(randomIntGenerator(0, collection.size() - 1),);
        }

        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / numberOfMeasurements;
    }

    @Override
    public long remove(int numberOfMeasurements) {
        final long startTime = System.nanoTime();

        for (int i = 0; i < numberOfMeasurements; i++) {
            collection.remove(randomIntGenerator(0, collection.size() - 1));
        }

        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / numberOfMeasurements;
    }

    @Override
    public long contains(int numberOfMeasurements) {
        final long startTime = System.nanoTime();

        for (int i = 0; i < numberOfMeasurements; i++) {
            collection.contains(randomIntGenerator(0, Integer.MAX_VALUE));
        }

        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / numberOfMeasurements;
    }

    @Override
    public long populate(int startValue, int endValue, int numberOfMeasurements) {
        final long startTime = System.nanoTime();

        for (int i = 0; i < numberOfMeasurements; i++) {
            collection.(randomIntGenerator(0, Integer.MAX_VALUE));
        }

        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / numberOfMeasurements;
    }

    @Override
    public long listIteratorAdd(int numberOfMeasurements) {
        return super.listIteratorAdd(numberOfMeasurements);
    }

    @Override
    public long listIteratorRemove(int numberOfMeasurements) {
        return super.listIteratorRemove(numberOfMeasurements);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public Map<String, Long> allMethodsMeasurements(int numberOfMeasurements) {
        return super.allMethodsMeasurements(numberOfMeasurements);
    }
}
