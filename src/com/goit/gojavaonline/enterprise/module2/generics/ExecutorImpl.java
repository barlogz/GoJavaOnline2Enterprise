package com.goit.gojavaonline.enterprise.module2.generics;

import java.util.List;

public class ExecutorImpl<T> implements  Executor<T>{
    @Override
    public void addTask() {
        addTask();
    }

    @Override
    public void addTask(Task<T> task) {

    }

    @Override
    public void addTask(Task<T> task, Validator<? super T> validator) {

    }

    @Override
    public void execute() {

    }

    @Override
    public List<T> getValidResults() {
        return null;
    }

    @Override
    public List<T> getInvalidResults() {
        return null;
    }
}
