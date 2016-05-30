package com.goit.gojavaonline.enterprise;

public interface MethodsForTesting {
    long add(int numberOfMeasurements);

    long get(int numberOfMeasurements);

    long remove(int numberOfMeasurements);

    long contains(int numberOfMeasurements);

    long populate(int startValue, int endValue, int numberOfMeasurements);

    long listIteratorAdd(int numberOfMeasurements);

    long listIteratorRemove(int numberOfMeasurements);
}

    /*List

    add(index)
    get(index)
    remove(index)
    contains(value)
    populate (наполнение коллекции)
    ListIterator.add()
            ListIterator.remove()
    Set

    add(value)
    remove(value)
    contains(value)
    populate (наполнение коллекции)
} */
