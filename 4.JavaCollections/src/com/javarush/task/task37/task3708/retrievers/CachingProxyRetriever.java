package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

/**
 * Created by Alexey Vedensky on 16.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class CachingProxyRetriever implements Retriever{
    private Storage storage;
    private OriginalRetriever originalRetriever;
    private LRUCache<Long, Object> lruCache;

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        this.originalRetriever = new OriginalRetriever(storage);
        lruCache = new LRUCache<>(16);
    }

    @Override
    public Object retrieve(long id) {
        Object obj = lruCache.find(id);
        if (obj == null) {
            obj = originalRetriever.retrieve(id);
            lruCache.set(id, obj);
        }
        return obj;
    }
}
