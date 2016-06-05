package com.goit.gojavaonline.enterprise.module2.generics;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl<T> implements Executor<T> {
    private List<Task<? extends T>> tasks = new ArrayList<>();
    private List<T> validResults = new ArrayList<>();
    private List<T> invalidResults = new ArrayList<>();

    boolean isExcecuteActivated;

    @Override
    public void addTask(Task<? extends T> task) {
        try {
            if (isExcecuteActivated) {
                throw new Exception("[ERROR]: Method execute() was already activated!");
            }
            tasks.add(task);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) {
        try {
            if (isExcecuteActivated) {
                throw new Exception("[ERROR]: Method execute() was already activated!");
            }
            task.execute();
            if (validator.isValid(task.getResult())) {
                validResults.add(task.getValue());
            } else {
                invalidResults.add(task.getValue());
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @Override
    public void execute() {
        Validator<Number> validator = new NumberValidator();
        for (Task<? extends T> task : tasks) {
            task.execute();
            if (validator.isValid((Number) task.getResult())) {
                validResults.add(task.getValue());
            } else {
                invalidResults.add(task.getValue());
            }
        }
        isExcecuteActivated = true;
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
