package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

/**
 * Класс, который может для любой строки вернуть некий
 * уникальный идентификатор и наоборот, по ранее полученному
 * идентификатору вернуть строку.
 */
public class Shortener {

    // Последнее значение идентификатора
    private volatile Long lastId = 0L;

    // Стратегия хранения данных
    private StorageStrategy storageStrategy;

    /**
     * Конструктор класса.
     *
     * @param storageStrategy Стратегия хранения данных.
     */
    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    /**
     * Метод возвращает идентификатор 'id' для заданной стройки.
     *
     * @param string Заданная строка.
     * @return Идентификатор 'id'.
     */
    public synchronized Long getId(String string) {
        if (storageStrategy.containsValue(string)) {
            return storageStrategy.getKey(string);
        }
        lastId++;
        storageStrategy.put(lastId, string);
        return lastId;
    }

    /**
     * Метод возвращает строку для заданного идентификатора.
     *
     * @param id Идентификатор.
     * @return Строку или null, если передан неверный идентификатор.
     */
    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }
}