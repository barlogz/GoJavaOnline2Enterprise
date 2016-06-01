package com.goit.gojavaonline.enterprise.Outputer;

import com.goit.gojavaonline.enterprise.ListCollection;
import com.goit.gojavaonline.enterprise.SetCollection;

import java.util.ArrayList;
import java.util.List;

public class Outputer {
    private List<String> resultForArrayList = new ArrayList<>();
    private List<String> resultForLinkedList = new ArrayList<>();
    private List<String> resultForHashSet = new ArrayList<>();
    private List<String> resultForTreeSet = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();
    private StringBuilder stringBuilderForFile = new StringBuilder();
    ListCollection listCollection;
    SetCollection setCollection;

    private void saveListReult(List list, List resultList, int size){
        resultList.add(0, list.getClass().getSimpleName());
        resultList.add(1, String.valueOf(listCollection.add(list, size)));
        resultList.add(2, String.valueOf(listCollection.get(list, size)));
        resultList.add(3, String.valueOf(listCollection.remove(list, size)));
        resultList.add(4, String.valueOf(listCollection.contains(list, size)));
        resultList.add(5, String.valueOf(listCollection.populate(list, size)));
        resultList.add(6, String.valueOf(listCollection.listIteratorAdd(list, size)));
        resultList.add(7, String.valueOf(listCollection.listIteratorRemove(list, size)));
    }



}
