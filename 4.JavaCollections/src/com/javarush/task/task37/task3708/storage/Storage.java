package com.javarush.task.task37.task3708.storage;

public interface Storage {
    void add(Object storedObject);
    Object get(long id);
}
