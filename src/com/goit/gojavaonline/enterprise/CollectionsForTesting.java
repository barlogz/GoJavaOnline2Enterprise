package com.goit.gojavaonline.enterprise;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;

public abstract class CollectionsForTesting {

    Collection<Integer> collection;
    int collectionSize;

    public abstract long add(int numberOfMeasurements);

    public long get(int numberOfMeasurements) {
        return 0;
    }

    public abstract long remove(int numberOfMeasurements);

    public abstract long contains(int numberOfMeasurements);

    public abstract long populate(int startValue, int endValue, int numberOfMeasurements);

    public long listIteratorAdd(int numberOfMeasurements) {
        return 0;
    }

    public long listIteratorRemove(int numberOfMeasurements) {
        return 0;
    }

    private void clear() {
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
//    public String allMethodsMeasurementsResultsToTableString(int numberOfMeasurements) {
//        Map<String, Long> allResults = this.allMethodsMeasurements(numberOfMeasurements);
//        MapUtils.debugPrint(System.out, "myMap", allResults);
//        return
//    }

}
   /* public String allMethodsMeasurementsResultsToString(int numberOfMeasurements) {
        Map<String, Long> allResults = this.allMethodsMeasurements(numberOfMeasurements);
        String result = "Test results for " + this.collection.getClass().toString()
                + " (" + "\"" +collectionSize/1000 + "K\" elements and "
                + "\"" + numberOfMeasurements + "\" measurements)\n";
        for (String key : allResults.keySet()) {
            result += "Method " + key + ": " + allResults.get(key) + " ns\n";
        }
        return result;
    }
*/