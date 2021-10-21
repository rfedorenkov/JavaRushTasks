package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {
    public void testStorage(Shortener shortener) {
        String oneString = "London is the capital of Great Britain";
        String twoString = "Я думаю, быть программистом - это круто";
        String threeString = "London is the capital of Great Britain";
        Long oneIds = shortener.getId(oneString);
        Long twoIds = shortener.getId(twoString);
        Long threeIds = shortener.getId(threeString);

        Assert.assertNotEquals(twoIds, oneIds);
        Assert.assertNotEquals(twoIds, threeIds);

        Assert.assertEquals(oneIds, threeIds);

        String one = shortener.getString(oneIds);
        String two = shortener.getString(twoIds);
        String three = shortener.getString(threeIds);

        Assert.assertEquals(oneString, one);
        Assert.assertEquals(twoString, two);
        Assert.assertEquals(threeString, three);
    }

    @Test
    public void testHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }
}