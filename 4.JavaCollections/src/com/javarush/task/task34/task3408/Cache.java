package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V oldValue = cache.get(key);
        if (oldValue == null) {
            V newInstance = clazz.getConstructor(key.getClass()).newInstance(key);
            cache.put(key, newInstance);
            return newInstance;
        }
        return oldValue;
    }

    public boolean put(V obj) {
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            K key = (K) method.invoke(obj);
            cache.put(key, obj);
            return true;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored) {
        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}