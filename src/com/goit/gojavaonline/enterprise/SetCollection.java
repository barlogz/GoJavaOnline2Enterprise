package com.goit.gojavaonline.enterprise;

import java.util.Collection;
import java.util.Set;

public class SetCollection extends CollectionsForTesting {

    @Override
    public long add(Collection collection, int numberOfMeasurements) {
        populateCollection(collection, numberOfMeasurements);
        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            collection.add(randomIntGenerator(0, collection.size() - 1));
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
}

//    @Override
//    public long contains(int numberOfMeasurements) {
//        final long startTime = System.nanoTime();
//
//        for (int i = 0; i < count; i++) {
//            collection.contains(randomIntGenerator(0, numberOfMeasurements));
//        }
//        final long finishTime = System.nanoTime();
//        return (finishTime - startTime) / numberOfMeasurements;
//    }

//    @Override
//    public long populate(int startValue, int endValue, int numberOfMeasurements) {
//        final long startTime = System.nanoTime();
//
//        for (int i = 0; i < numberOfMeasurements; i++) {
//            this.collection.clear();
//            while (collection.size() < collectionSize) {
//                collection.add(randomIntGenerator(startValue, endValue));
//            }
//        }
//        final long finishTime = System.nanoTime();
//        return (finishTime - startTime) / numberOfMeasurements;
//    }
//}
