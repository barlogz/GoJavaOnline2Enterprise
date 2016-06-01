package com.goit.gojavaonline.enterprise.Outputer;

import com.goit.gojavaonline.enterprise.ListCollection;
import com.goit.gojavaonline.enterprise.SetCollection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Measurer {
    private List<String> resultForArrayList = new ArrayList<>();
    private List<String> resultForLinkedList = new ArrayList<>();
    private List<String> resultForHashSet = new ArrayList<>();
    private List<String> resultForTreeSet = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();
    private StringBuilder stringBuilderForFile = new StringBuilder();
    ListCollection listCollection = new ListCollection(int collectionSize, List<Integer> list);
    SetCollection setCollection;

    private void saveListResults(List list, List resultList, int numberOfMeasurements){
        resultList.add(0, list.getClass().getSimpleName());
        resultList.add(1, String.valueOf(listCollection.add(numberOfMeasurements)));
        resultList.add(2, String.valueOf(listCollection.get(numberOfMeasurements)));
        resultList.add(3, String.valueOf(listCollection.remove(numberOfMeasurements)));
        resultList.add(4, String.valueOf(listCollection.contains(numberOfMeasurements)));
        resultList.add(5, String.valueOf(listCollection.populate(0, Integer.MAX_VALUE, numberOfMeasurements)));
        resultList.add(6, String.valueOf(listCollection.listIteratorAdd(numberOfMeasurements)));
        resultList.add(7, String.valueOf(listCollection.listIteratorRemove(numberOfMeasurements)));
    }

    public void getListResults(List list, int numberOfMeasurements) {
        if(list instanceof java.util.ArrayList) {
            saveListResults(list, resultForArrayList, numberOfMeasurements);
        }
        else if (list instanceof java.util.LinkedList) {
            saveListResults(list, resultForLinkedList, numberOfMeasurements);
        }
    }

    private void saveSetResults(Set set, List resultSet, int numberOfMeasurements) {
        resultSet.add(0, set.getClass().getSimpleName());
        resultSet.add(1, String.valueOf(setCollection.add(numberOfMeasurements)));
        resultSet.add(2, "-");
        resultSet.add(3, String.valueOf(setCollection.remove(numberOfMeasurements)));
        resultSet.add(4, String.valueOf(setCollection.contains(numberOfMeasurements)));
        resultSet.add(5, String.valueOf(setCollection.populate(0, Integer.MAX_VALUE, numberOfMeasurements)));
        resultSet.add(6, "-");
        resultSet.add(7, "-");
    }

    public void getSetResults(Set set, int numberOfMeasurements) {
        if(set instanceof java.util.HashSet) {
            saveSetResults(set, resultForHashSet, numberOfMeasurements);
        }
        else if (set instanceof java.util.TreeSet) {
            saveSetResults(set, resultForTreeSet, numberOfMeasurements);
        }
    }

    public void measure(int numberOfMeasurements) {
        getListResults(new ArrayList<>(), numberOfMeasurements);
        getListResults(new LinkedList<>(), numberOfMeasurements);
        getSetResults(new HashSet<>(), numberOfMeasurements);
        getSetResults(new TreeSet<>(), numberOfMeasurements);
    }
    public void printResults(String strSize, int numberOfMeasurements) {
        measure(numberOfMeasurements);
        stringBuilder.append(String.format("%52s%n", "--------------------------------------------------------------------------------------------------------------------------"));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", strSize, "add", "get", "remove", "contains", "populate", "listIteratorAdd", "listIteratorRemove"));
        stringBuilder.append(String.format("%52s%n", "--------------------------------------------------------------------------------------------------------------------------"));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", resultForArrayList.get(0), resultForArrayList.get(1), resultForArrayList.get(2), resultForArrayList.get(3),
                resultForArrayList.get(4), resultForArrayList.get(5), resultForArrayList.get(6), resultForArrayList.get(7)));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", resultForLinkedList.get(0), resultForLinkedList.get(1), resultForLinkedList.get(2), resultForLinkedList.get(3),
                resultForLinkedList.get(4), resultForLinkedList.get(5), resultForLinkedList.get(6), resultForLinkedList.get(7)));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", resultForHashSet.get(0), resultForHashSet.get(1), resultForHashSet.get(2), resultForHashSet.get(3),
                resultForHashSet.get(4), resultForHashSet.get(5), resultForHashSet.get(6), resultForHashSet.get(7)));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", resultForTreeSet.get(0), resultForTreeSet.get(1), resultForTreeSet.get(2), resultForTreeSet.get(3),
                resultForTreeSet.get(4), resultForTreeSet.get(5), resultForTreeSet.get(6), resultForTreeSet.get(7)));
        stringBuilder.append(String.format("%52s%n", "--------------------------------------------------------------------------------------------------------------------------"));
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(String.format("\n"));
        System.out.println(stringBuilder.toString());
        stringBuilderForFile.append(stringBuilder);
        stringBuilder.setLength(0);
    }

    public void writeToFile(String fileName){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)))) {
            bufferedWriter.write(stringBuilderForFile.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
