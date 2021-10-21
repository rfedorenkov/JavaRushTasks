package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date start = new Date();
        strings.stream()
                .map(shortener::getId)
                .forEach(ids::add);
        return new Date().getTime() - start.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date start = new Date();
        ids.stream()
                .map(shortener::getString)
                .forEach(strings::add);
        return new Date().getTime() - start.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = IntStream.range(0, 10_000)
                .mapToObj(i -> Helper.generateRandomString())
                .collect(Collectors.toSet());

        long timeToGetIdsOne= getTimeToGetIds(shortener1, origStrings, new HashSet<>());
        long timeToGetIdsTwo = getTimeToGetIds(shortener2, origStrings, new HashSet<>());
        Assert.assertTrue(timeToGetIdsOne > timeToGetIdsTwo);

        long timeToGetStringsOne = getTimeToGetStrings(shortener1, new HashSet<>(), origStrings);
        long timeToGetStringsTwo = getTimeToGetStrings(shortener2, new HashSet<>(), origStrings);
        Assert.assertEquals(timeToGetStringsOne, timeToGetStringsTwo, 30);
    }
}