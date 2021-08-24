package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestaurantTest {

    @Test
    public void dishTestString() {
        Assert.assertEquals("FISH, STEAK, SOUP, JUICE, WATER", Dish.allDishesToString());
    }

    @Test
    public void advertisementDivisionByZero() {
        try {
            new Advertisement(new Object(), "Test", 100, 0, 20);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testSortVideosAllAd() {
        long start = System.currentTimeMillis();
        List<Dish> dishes = new ArrayList<>();
        dishes.add(Dish.FISH);
        dishes.add(Dish.STEAK);
        dishes.add(Dish.SOUP);
        dishes.add(Dish.JUICE);
        dishes.add(Dish.WATER);

        int totalTime = dishes.stream()
                .mapToInt(Dish::getDuration)
                .sum() * 60;

        AdvertisementManager advertisementManager = new AdvertisementManager(totalTime);
        advertisementManager.processVideos();
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void testSortVideosOneAd() {
        long start = System.currentTimeMillis();
        List<Dish> dishes = new ArrayList<>();
        dishes.add(Dish.WATER);

        int totalTime = dishes.stream()
                .mapToInt(Dish::getDuration)
                .sum() * 60;

        AdvertisementManager advertisementManager = new AdvertisementManager(totalTime);
        advertisementManager.processVideos();

        System.out.println(String.format("Total time: %d ms", System.currentTimeMillis() - start));
    }

    @Test
    public void testStaticManagerCreate() {
        StatisticManager instance = StatisticManager.INSTANCE;
    }

    @Test
    public void testDirectorTabletMethods() {
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}