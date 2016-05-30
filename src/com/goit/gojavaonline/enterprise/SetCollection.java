package com.goit.gojavaonline.enterprise;

import java.util.Set;

public class SetCollection extends CollectionsForTesting {
    public SetCollection(int collectionSize, Set<Integer> set) {
        this.collection = set;
        this.collectionSize = collectionSize;
        this.populate(0, Integer.MAX_VALUE, 1);
    }

    @Override
    public long add(int numberOfMeasurements) {
        final long startTime = System.nanoTime();

        for (int i = 0; i < numberOfMeasurements; i++) {
            collection.add(randomIntGenerator(0, collection.size() - 1));
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
            this.collection.clear();
            while (collection.size() < collectionSize) {
                collection.add(randomIntGenerator(startValue, endValue));
            }
        }
        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / numberOfMeasurements;
    }
}
