package com.javarush.task.task33.task3310.strategy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Класс стратегии основанный на файлах.
 * Работает аналогично классу OurHashMapStorageStrategy.
 */
public class FileStorageStrategy implements StorageStrategy {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10_000L;
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize = DEFAULT_BUCKET_SIZE_LIMIT;

    public FileStorageStrategy() {
        IntStream.range(0, table.length)
                .forEach(i -> table[i] = new FileBucket());
    }

    /**
     * Геттер лимита размера файла.
     *
     * @return Лимит размера файла.
     */
    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    /**
     * Сеттер лимита размера файла.
     *
     * @param bucketSizeLimit Новый лимит размера файла.
     */
    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    /**
     * See OurHashMapStorageStrategy
     */
    int hash(Long k) {
        return k.hashCode();
    }

    /**
     * See OurHashMapStorageStrategy
     */
    int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    /**
     * See OurHashMapStorageStrategy
     */
    Entry getEntry(Long key) {
        if (size == 0) {
            return null;
        }

        int hash = hash(key);
        int index = indexFor(hash, table.length);
        for (Entry entry = table[index].getEntry(); entry != null; entry = entry.next) {
            if (key.equals(entry.key)) {
                return entry;
            }
        }
        return null;
    }

    /**
     * See OurHashMapStorageStrategy
     */
    void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];

        for (int i = 0; i < newTable.length; i++) {
            newTable[i] = new FileBucket();
        }

        transfer(newTable);

        Arrays.stream(table)
                .forEach(FileBucket::remove);

        table = newTable;
    }

    /**
     * See OurHashMapStorageStrategy
     */
    void transfer(FileBucket[] newTable) {
        int newCapacity = newTable.length;
        maxBucketSize = 0;

        for (FileBucket fileBucket : table) {
            Entry entry = fileBucket.getEntry();
            while (entry != null) {
                Entry next = entry.next;
                final int index = indexFor(entry.getKey().hashCode(), newCapacity);
                entry.next = newTable[index].getEntry();
                entry = next;
            }

            final long bucketFileSize = fileBucket.getFileSize();
            if (bucketFileSize > maxBucketSize) {
                maxBucketSize = bucketFileSize;
            }
        }
    }

    /**
     * See OurHashMapStorageStrategy
     */
    void addEntry(int hash, Long key, String value, int bucketIndex) {
        if (maxBucketSize > bucketSizeLimit) {
            resize(2 * table.length);
            bucketIndex = indexFor(key.hashCode(), table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }

    /**
     * See OurHashMapStorageStrategy
     */
    void createEntry(int hash, Long key, String value, int bucketIndex) {
        final Entry entry = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, entry));
        size++;

        final long bucketSize = table[bucketIndex].getFileSize();
        if (bucketSize > maxBucketSize) {
            maxBucketSize = bucketSize;
        }
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
        for (Entry entry = table[index].getEntry(); entry != null; entry = entry.next) {
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
        for (FileBucket fileBucket : table) {
            for (Entry entry = fileBucket.getEntry(); entry != null; entry = entry.next) {
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
