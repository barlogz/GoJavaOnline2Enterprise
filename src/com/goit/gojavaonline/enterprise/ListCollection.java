package com.goit.gojavaonline.enterprise;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class ListCollection extends CollectionsForTesting {
//    public ListCollection() {
//        this.collection = list;
//        this.collectionSize = collectionSize;
//        this.populate(0, Integer.MAX_VALUE, 1);
//    }

    @Override
    public long add(Collection collection, int numberOfMeasurements) {
        populateCollection(collection, numberOfMeasurements);
        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            ((List<Integer>) collection).add(randomIntGenerator(0, numberOfMeasurements), i);
        }

        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / count;
    }

    @Override
    public long get(List list, int numberOfMeasurements) {
        populateCollection(list, numberOfMeasurements);
        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            list.get(randomIntGenerator(0, numberOfMeasurements - 1));
        }

        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / count;
    }

    @Override
    public long remove(Collection collection, int numberOfMeasurements) {
        populateCollection(collection, numberOfMeasurements);
        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            collection.remove(randomIntGenerator(0, collection.size() - 1));
        }

        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / count;
    }

//    @Override
//    public long contains(Collection collection, int numberOfMeasurements) {
//        populateCollection(collection, numberOfMeasurements);
//        final long startTime = System.nanoTime();
//
//        for (int i = 0; i < numberOfMeasurements; i++) {
//            collection.contains(randomIntGenerator(0, Integer.MAX_VALUE));
//        }
//
//        final long finishTime = System.nanoTime();
//        return (finishTime - startTime) / numberOfMeasurements;
//    }

//    @Override
//    public long populate(Collection collection, int numberOfMeasurements) {
//        long sum = 0;
//
//        for (int i = 0; i < numberOfMeasurements; i++) {
//            collection.clear();
//            final long startTime = System.nanoTime();
//            for (int j = 0; j < numberOfMeasurements; j++) {
//                collection.add(randomIntGenerator(0, numberOfMeasurements));
//            }
//            final long finishTime = System.nanoTime();
//            sum += finishTime - startTime;
//
//        }
//        return sum / numberOfMeasurements;
//    }

    @Override
    public long listIteratorAdd(List list, int numberOfMeasurements) {
        populateCollection(list, numberOfMeasurements);
        ListIterator<Integer> listIterator = list.listIterator();
        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            listIterator.add(i);
        }
        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / count;
    }

    @Override
    public long listIteratorRemove(List list, int numberOfMeasurements) {
        populateCollection(list, numberOfMeasurements);
        ListIterator<Integer> listIterator = list.listIterator();
        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            listIterator.next();
            listIterator.remove();
        }
        final long finishTime = System.nanoTime();
        return (finishTime - startTime) / count;
    }
}
