package com.goit.gojavaonline.enterprise;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class CollectionsForTesting implements MethodsForTesting {

    Collection<Integer> collection;
    int collectionSize;


    @Override
    public long add(int numberOfMeasurements) {
        return 0;
    }

    @Override
    public long get(int numberOfMeasurements) {
        return 0;
    }

    @Override
    public long remove(int numberOfMeasurements) {
        return 0;
    }

    @Override
    public long contains(int numberOfMeasurements) {
        return 0;
    }

    @Override
    public long populate(int startValue, int endValue, int numberOfMeasurements) {
        return 0;
    }

    @Override
    public long listIteratorAdd(int numberOfMeasurements) {
        return 0;
    }

    @Override
    public long listIteratorRemove(int numberOfMeasurements) {
        return 0;
    }

    public void clear() {
        this.collection.clear();
    }

    static int randomIntGenerator(int min, int max) {
        return (min + (int) (Math.random() * ((max - min) + 1)));
    }

    public Map<String, Long> allMethodsMeasurements(int numberOfMeasurements) {
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

}
