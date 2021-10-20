package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Objects;

/**
 * Класс сущности для стратегии OurHashMapStorageStrategy.
 */
public class Entry implements Serializable {
    private static final long serialVersionUID = 1L;

    Long key;
    String value;
    Entry next;
    int hash;

    /**
     * Конструктор класса.
     *
     * @param hash Хэш-код.
     * @param key Ключ.
     * @param value Значение.
     * @param next Следующий элемент.
     */
    public Entry(int hash, Long key, String value, Entry next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    /**
     * Геттер ключа.
     *
     * @return Ключ.
     */
    public Long getKey() {
        return key;
    }

    /**
     * Геттер значения.
     *
     * @return Значение.
     */
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry entry = (Entry) o;
        return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}