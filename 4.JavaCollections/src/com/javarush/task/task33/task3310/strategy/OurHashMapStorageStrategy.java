package com.javarush.task.task33.task3310.strategy;

/**
 * Класс стратегии основанный на собственной реализации HashMap.
 */
public class OurHashMapStorageStrategy implements StorageStrategy {
    /**
     * Метод должен вернуть true, если хранилище содержит переданный ключ.
     *
     * @param key Ключ.
     * @return true - если содержит ключ, в противном - false.
     */
    @Override
    public boolean containsKey(Long key) {
        return false;
    }

    /**
     * Метод должен вернуть true, если хранилище содержит переданное значение.
     *
     * @param value Значение.
     * @return true - если содержит значение, в противном - false.
     */
    @Override
    public boolean containsValue(String value) {
        return false;
    }

    /**
     * Добавляет в хранилище новую пару ключ - значение.
     *
     * @param key   Ключ.
     * @param value Значение.
     */
    @Override
    public void put(Long key, String value) {

    }

    /**
     * Возвращает ключ для переданного значения.
     *
     * @param value Значение.
     * @return Ключ.
     */
    @Override
    public Long getKey(String value) {
        return null;
    }

    /**
     * Возвращает значение для переданного ключа.
     *
     * @param key Ключ.
     * @return Значение.
     */
    @Override
    public String getValue(Long key) {
        return null;
    }
}