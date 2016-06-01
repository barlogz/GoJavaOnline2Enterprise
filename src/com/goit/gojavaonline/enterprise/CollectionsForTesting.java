package com.goit.gojavaonline.enterprise;

import java.util.Collection;
import java.util.List;

public abstract class CollectionsForTesting {

    Collection<Integer> collection;
    int collectionSize;
    public static final int count = 100;


    public abstract long add(Collection collection, int numberOfMeasurements);

    public long get(List list, int numberOfMeasurements) {
        return 0;
    }

    public abstract long remove(Collection collection, int numberOfMeasurements);

    public long contains(Collection collection, int numberOfMeasurements) {
        populateCollection(collection, numberOfMeasurements);
        final long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            collection.contains(randomIntGenerator(0, numberOfMeasurements));
        }
        return (System.nanoTime() - startTime) / count;
    }

    public long populate(Collection collection, int numberOfMeasurements){
        long sum = 0;

        for (int i = 0; i < numberOfMeasurements; i++) {
            collection.clear();
            final long startTime = System.nanoTime();
            for (int j = 0; j < numberOfMeasurements; j++) {
                collection.add(randomIntGenerator(0, numberOfMeasurements));
            }
            final long finishTime = System.nanoTime();
            sum += finishTime - startTime;

        }
        return sum / numberOfMeasurements;
    }

    public long listIteratorAdd(List list, int numberOfMeasurements) {
        return 0;
    }

    public long listIteratorRemove(List list, int numberOfMeasurements) {
        return 0;
    }

    private void clear() {
        this.collection.clear();
    }

    static int randomIntGenerator(int min, int max) {
        return (min + (int) (Math.random() * ((max - min) + 1)));
    }

    public void populateCollection(Collection collection, int size) {
        collection.clear();
        for (int i = 0; i < size; i++) {
            collection.add(i);
        }
    }

   /* public Map<String, Long> allMethodsMeasurements(int numberOfMeasurements) {
        Map<String, Long> results = new HashMap<>();
        results.put("add", this.add(numberOfMeasurements));
        results.put("get", this.get(numberOfMeasurements));
        results.put("remove", this.remove(numberOfMeasurements));
        results.put("contains", this.contains(numberOfMeasurements));
        results.put("populate", this.populate(0, Integer.MAX_VALUE, numberOfMeasurements));
        results.put("listIteratorAdd", this.listIteratorAdd(numberOfMeasurements));
        results.put("listIteratorRemove", this.listIteratorRemove(numberOfMeasurements));

        this.clear();

        return results;
    }

    public String allMethodsMeasurementsResultsToString(int numberOfMeasurements) {
        Map<String, Long> allResults = this.allMethodsMeasurements(numberOfMeasurements);
        String result = "Test results for " + this.collection.getClass().toString()
                + " (" + "\"" + collectionSize / 1000 + "K\" elements and "
                + "\"" + numberOfMeasurements + "\" measurements)\n";
        for (String key : allResults.keySet()) {
            result += "Method " + key + ": " + allResults.get(key) + " ns\n";
        }
        return result;
    }
    */
}