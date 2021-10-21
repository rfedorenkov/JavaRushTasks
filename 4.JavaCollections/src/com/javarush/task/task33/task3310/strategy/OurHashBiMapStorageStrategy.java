package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;

public class OurHashBiMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> k2v = new HashMap<>();
    private HashMap<String, Long> v2k = new HashMap<>();

    /**
     * Метод должен вернуть true, если хранилище содержит переданный ключ.
     *
     * @param key Ключ.
     * @return true - если содержит ключ, в противном - false.
     */
    @Override
    public boolean containsKey(Long key) {
        return k2v.containsKey(key);
    }

    /**
     * Метод должен вернуть true, если хранилище содержит переданное значение.
     *
     * @param value Значение.
     * @return true - если содержит значение, в противном - false.
     */
    @Override
    public boolean containsValue(String value) {
        return v2k.containsKey(value);
    }

    /**
     * Добавляет в хранилище новую пару ключ - значение.
     *
     * @param key   Ключ.
     * @param value Значение.
     */
    @Override
    public void put(Long key, String value) {
        k2v.put(key, value);
        v2k.put(value, key);
    }

    /**
     * Возвращает ключ для переданного значения.
     *
     * @param value Значение.
     * @return Ключ.
     */
    @Override
    public Long getKey(String value) {
        return v2k.get(value);
    }

    /**
     * Возвращает значение для переданного ключа.
     *
     * @param key Ключ.
     * @return Значение.
     */
    @Override
    public String getValue(Long key) {
        return k2v.get(key);
    }
}