package com.goit.gojavaonline.enterprise;

import com.goit.gojavaonline.enterprise.Outputer.Chart;

import java.util.*;

import static com.goit.gojavaonline.enterprise.Outputer.ChartAlign.*;

public class Main {
    private static int numberOfMeasurements = 100;
    private static int numberOfElements = 1_000;

    public static void main(String[] args) {
        ListCollection listCollection;
        Map<String, Long> testResults;

        Chart chart = new Chart(new ArrayList<String>() {{
            add("populate");
            add("add");
            add("get");
            add("contains");
            add("remove");
            add("listIteratorAdd");
            add("listIteratorRemove");
        }});
        chart.setColumnSeparator('|');
        chart.setAlign(LEFT);
        chart.addColumn(0, "Collection");

        listCollection = new ListCollection(numberOfElements, new ArrayList<>());
        testResults = listCollection.allMethodsMeasurements(numberOfMeasurements);
        chart.addRow(testResults);
        chart.setCell(1, 0, "ArrayList(" + numberOfElements + ")");

        listCollection = new ListCollection(numberOfElements, new LinkedList<>());
        testResults = listCollection.allMethodsMeasurements(numberOfMeasurements);
        chart.addRow(testResults);
        chart.setCell(2, 0, "LinkedList(" + numberOfElements + ")");

        SetCollection setCollection = new SetCollection(numberOfElements, new HashSet<>());
        testResults = setCollection.allMethodsMeasurements(numberOfMeasurements);
        chart.addRow(testResults);
        chart.setCell(3, 0, "HashSet(" + numberOfElements + ")");

        setCollection = new SetCollection(numberOfElements, new TreeSet<>());
        testResults = setCollection.allMethodsMeasurements(numberOfMeasurements);
        chart.addRow(testResults);
        chart.setCell(4, 0, "TreeSet(" + numberOfElements + ")");

        chart.toConsole();
        System.out.println();
        chart.toFile("");








//        ListCollection arrayList = new ListCollection(numberOfElements, new ArrayList<>());
//        System.out.println(arrayList.allMethodsMeasurementsResultsToTableString(numberOfMeasurements));
//
//        ListCollection arrayList = new ListCollection(numberOfElements, new ArrayList<>());
//        System.out.println(arrayList.allMethodsMeasurementsResultsToString(numberOfMeasurements));
//
//        ListCollection linkedList = new ListCollection(numberOfElements, new LinkedList<>());
//        System.out.println(linkedList.allMethodsMeasurementsResultsToString(numberOfMeasurements));
//
//        SetCollection hashSet = new SetCollection(numberOfElements, new HashSet<>());
//        System.out.println(hashSet.allMethodsMeasurementsResultsToString(numberOfMeasurements));
//
//        SetCollection treeSet = new SetCollection(numberOfElements, new TreeSet<>());
//        System.out.println(treeSet.allMethodsMeasurementsResultsToString(numberOfMeasurements));



//        MapUtils.debugPrint(System.out, "myMap",arrayList.allMethodsMeasurements(numberOfMeasurements));
//        MapUtils.verbosePrint(System.out, "myMap",arrayList.allMethodsMeasurements(numberOfMeasurements));
    }

}



    /*     Написать программу для сравнения эффективности коллекций:

            Программа должна сравнивать различные имплементации коллекций по эффективности выполнения следующих операций:

            List

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


            Сравнения должны выполнятся на объемах: 10К (10 000) 100К 1000К элементов.

            Для каждого набора (10К, 100К, 1000К) выполнить не менее 100 измерений и вычислить среднее значение.

            Результаты измерений вывести на экран и сохранить в файл в виде таблицы:

            add
            get
            remove
            contains
            populate
            iterator.add
            iterator.remove
            ArrayList
            LinkedList
            HashSet
            TreeSet
    */
