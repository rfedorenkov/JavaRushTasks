package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    /**
     * Метод возвращает множество идентификаторов для переданного множества строк.
     *
     * @param shortener Shortener.
     * @param strings   Множество строк.
     * @return Множество идентификаторов.
     */
    static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        return strings.stream()
                .map(shortener::getId)
                .collect(Collectors.toSet());
    }

    /**
     * Метод возвращает множество строк для переданного множества идентификаторов.
     *
     * @param shortener Shortener.
     * @param keys      Множество идентификаторов.
     * @return Множество строк.
     */
    static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        return keys.stream()
                .map(shortener::getString)
                .collect(Collectors.toSet());
    }

    /**
     * Метод тестирует работу переданной стратегии
     * на определенном количестве элементов.
     *
     * @param strategy       Стратегия.
     * @param elementsNumber Количество элементов.
     */
    static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> testSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            testSet.add(Helper.generateRandomString());
        }

        final Shortener shortener = new Shortener(strategy);

        Date start = new Date();
        Set<Long> testIds = getIds(shortener, testSet);
        long result = new Date().getTime() - start.getTime();
        Helper.printMessage(String.valueOf(result));

        start = new Date();
        Set<String> testKeys = getStrings(shortener, testIds);
        result = new Date().getTime() - start.getTime();
        Helper.printMessage(String.valueOf(result));

        Helper.printMessage(testSet.containsAll(testKeys) ? "Тест пройден." : "Тест не пройден.");
    }

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10_000);
        testStrategy(new OurHashMapStorageStrategy(), 10_000);
    }
}