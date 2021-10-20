package com.javarush.task.task33.task3310.strategy;

/**
 * Класс стратегии основанный на собственной реализации HashMap.
 */
public class OurHashMapStorageStrategy implements StorageStrategy {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    /**
     * See HashMap JDK 1.7
     */
    int hash(Long k) {
        return k.hashCode();
    }

    /**
     * See HashMap JDK 1.7
     */
    int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    /**
     * See HashMap JDK 1.7
     */
    Entry getEntry(Long key) {
        if (size == 0) {
            return null;
        }

        int hash = hash(key);
        int index = indexFor(hash, table.length);
        for (Entry entry = table[index]; entry != null; entry = entry.next) {
            if (key.equals(entry.key)) {
                return entry;
            }
        }
        return null;
    }

    /**
     * See HashMap JDK 1.7
     */
    void resize(int newCapacity) {
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    /**
     * See HashMap JDK 1.7
     */
    void transfer(Entry[] newTable) {
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int i = 0; i < src.length; i++) {
            Entry entry = src[i];
            if (entry != null) {
                src[i] = null;
                do {
                    Entry next = entry.next;
                    int index = indexFor(entry.hash, newCapacity);
                    entry.next = newTable[index];
                    newTable[index] = entry;
                    entry = next;
                } while (entry != null);
            }
        }
    }

    /**
     * See HashMap JDK 1.7
     */
    void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, entry);
        if (size++ >= threshold) {
            resize(2 * table.length);
        }
    }

    /**
     * See HashMap JDK 1.7
     */
    void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, entry);
        size++;
    }

    /**
     * Метод должен вернуть true, если хранилище содержит переданный ключ.
     *
     * @param key Ключ.
     * @return true - если содержит ключ, в противном - false.
     */
    @Override
    public boolean containsKey(Long key) {
        return getValue(key) != null;
    }

    /**
     * Метод должен вернуть true, если хранилище содержит переданное значение.
     *
     * @param value Значение.
     * @return true - если содержит значение, в противном - false.
     */
    @Override
    public boolean containsValue(String value) {

        return getKey(value) != null;
    }

    /**
     * Добавляет в хранилище новую пару ключ - значение.
     *
     * @param key   Ключ.
     * @param value Значение.
     */
    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        for (Entry entry = table[index]; entry != null; entry = entry.next) {
            if (key.equals(entry.key)) {
                entry.value = value;
                return;
            }
        }
        addEntry(hash, key, value, index);
    }

    /**
     * Возвращает ключ для переданного значения.
     *
     * @param value Значение.
     * @return Ключ.
     */
    @Override
    public Long getKey(String value) {
        for (Entry entryTable : table) {
            for (Entry entry = entryTable; entry != null; entry = entry.next) {
                if (value.equals(entry.value)) {
                    return entry.getKey();
                }
            }
        }
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
        Entry entry = getEntry(key);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }
}