package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.storage.Storage;

public class OriginalRetriever implements Retriever {
    Storage storage;

    public OriginalRetriever(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Object retrieve(long id) {
        return storage.get(id);
    }
}
