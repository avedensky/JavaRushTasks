package com.javarush.task.task37.task3708.storage;

import java.util.HashMap;

public class FarAwayStorage implements Storage {
    private long id = 0;
    private HashMap<Long, Object> storageMap = new HashMap<>();

    @Override
    public void add(Object o) {
        storageMap.put(id++, o);
    }

    @Override
    public Object get(long id) {
        System.out.println("Getting a value for id #" + id + " from FarAwayStorage...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {

        }
        return storageMap.get(id);
    }
}
