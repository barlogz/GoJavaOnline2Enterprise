package com.goit.gojavaonline.enterprise;

import java.util.ArrayList;

public class TestClassForList {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 1_000; i++) {
            arrayList.add(randomIntGenerator(0, arrayList.size()-1), i);
        }

        long finishTime = System.currentTimeMillis();
        long timeConsumedMillis = finishTime - startTime;
        System.out.println(timeConsumedMillis);
    }

    private static int randomIntGenerator (int min, int max) {
        return (min + (int) (Math.random() * ((max - min) + 1)));
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
