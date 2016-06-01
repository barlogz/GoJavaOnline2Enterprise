package com.goit.gojavaonline.enterprise;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class ListCollection extends CollectionsForTesting {
    public ListCollection(int collectionSize, List<Integer> list) {
        this.collection = list;
        this.collectionSize = collectionSize;
        this.populate(0, Integer.MAX_VALUE, 1);
    }

    @Override
    public long add(Collection collection, int numberOfMeasurements) {
        populateCollection(collection, numberOfMeasurements);
        final long startTime = System.nanoTime();

        for (int i = 0; i < numberOfMeasurements; i++) {
            ((List<Integer>) collection).add(randomIntGenerator(0, collection.size() - 1), i);
        }

        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / numberOfMeasurements;
    }

    @Override
    public long get(int numberOfMeasurements) {
        populateCollection(collection, numberOfMeasurements);
        final long startTime = System.nanoTime();

        for (int i = 0; i < numberOfMeasurements; i++) {
            ((List<Integer>) collection).get(randomIntGenerator(0, collection.size() - 1));
        }

        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / numberOfMeasurements;
    }

    @Override
    public long remove(int numberOfMeasurements) {
        populateCollection(collection, numberOfMeasurements);
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

    @Override
    public long listIteratorAdd(List list, int numberOfMeasurements) {
        populateCollection(list, numberOfMeasurements);
        ListIterator<Integer> listIterator = ((List<Integer>) collection).listIterator();
        final long startTime = System.nanoTime();

        for (int i = 0; i < numberOfMeasurements; i++) {
            listIterator.add(i);
        }
        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / numberOfMeasurements;
    }

    @Override
    public long listIteratorRemove(List list, int numberOfMeasurements) {
        populateCollection(list, numberOfMeasurements);
        ListIterator<Integer> listIterator = ((List<Integer>) collection).listIterator();
        final long startTime = System.nanoTime();

        for (int i = 0; i < numberOfMeasurements; i++) {
            listIterator.next();
            listIterator.remove();
        }
        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / numberOfMeasurements;
    }
}
