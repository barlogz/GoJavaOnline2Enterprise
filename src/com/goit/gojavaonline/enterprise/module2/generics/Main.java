package com.goit.gojavaonline.enterprise.module2.generics;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List intTasks = Arrays.asList(10, 20, 30);
        test(intTasks);
    }

    public static void test(List<Task<Integer>> intTasks) {
        Executor<Number> numberExecutor = new ExecutorImpl<>();

        for (Task<Integer> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }
        numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }
}
