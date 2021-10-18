package com.javarush.task.task33.task3310.strategy;

/**
 * Паттерн стратегия (Strategy).
 */
public interface StorageStrategy {

    /**
     * Метод должен вернуть true, если хранилище содержит переданный ключ.
     *
     * @param key Ключ.
     * @return true - если содержит ключ, в противном - false.
     */
    boolean containsKey(Long key);

    /**
     * Метод должен вернуть true, если хранилище содержит переданное значение.
     *
     * @param value Значение.
     * @return true - если содержит значение, в противном - false.
     */
    boolean containsValue(String value);

    /**
     * Добавляет в хранилище новую пару ключ - значение.
     *
     * @param key Ключ.
     * @param value Значение.
     */
    void put(Long key, String value);

    /**
     * Возвращает ключ для переданного значения.
     *
     * @param value Значение.
     * @return Ключ.
     */
    Long getKey(String value);

    /**
     * Возвращает значение для переданного ключа.
     * @param key Ключ.
     * @return Значение.
     */
    String getValue(Long key);

}