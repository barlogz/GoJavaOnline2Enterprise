package com.goit.gojavaonline.enterprise;

import com.goit.gojavaonline.enterprise.Outputer.BordersType;
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
        chart.setColumnSeparator("|");
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

        chart.toConsole(BordersType.WITHOUT_HEADER);

    }

}
