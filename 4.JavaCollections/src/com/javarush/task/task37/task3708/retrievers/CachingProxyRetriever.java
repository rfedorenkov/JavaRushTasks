package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private LRUCache lruCache;
    private OriginalRetriever original;

    public CachingProxyRetriever(Storage storage) {
        original = new OriginalRetriever(storage);
        lruCache = new LRUCache(16);
    }

    @Override
    public Object retrieve(long id) {
        Object o = lruCache.find(id);
        if (o == null) {
            Object retrieve = original.retrieve(id);
            lruCache.set(id, retrieve);
            return retrieve;


        }
        return o;
    }
}