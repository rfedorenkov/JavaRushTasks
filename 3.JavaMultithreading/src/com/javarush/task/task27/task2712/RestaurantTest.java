package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.AdvertisementStorage;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

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
    public void testDirectorPrintAdvertisementProfit() {
        StatisticManager manager = StatisticManager.INSTANCE;

        VideoSelectedEventDataRow oneVideo = new VideoSelectedEventDataRow(AdvertisementStorage.getInstance().list(), 500, 1680);
        VideoSelectedEventDataRow twoVideo = new VideoSelectedEventDataRow(AdvertisementStorage.getInstance().list(), 120, 1680);

        VideoSelectedEventDataRow threeVideo = new VideoSelectedEventDataRow(AdvertisementStorage.getInstance().list(), 187, 1680);
        threeVideo.setCurrentDate(new Date(102020202020L));

        manager.register(oneVideo);
        manager.register(twoVideo);
        manager.register(threeVideo);

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
    }

    @Test
    public void testDirectorPrintCookWorkloading() {

        StatisticManager manager = StatisticManager.INSTANCE;
        List<Dish> dishes = new ArrayList<>();
        dishes.add(Dish.WATER);
        dishes.add(Dish.FISH);

        manager.register(new CookedOrderEventDataRow("Планшет №1", "Валерий", 28 * 60, dishes));
        manager.register(new CookedOrderEventDataRow("Планшет №2", "Александр", 28 * 60, dishes));
        manager.register(new CookedOrderEventDataRow("Планшет №3", "Александр", 28 * 60, dishes));

        CookedOrderEventDataRow cookedOne = new CookedOrderEventDataRow("Планшет №3", "Николай", 28 * 60, dishes);
        cookedOne.setCurrentDate(new GregorianCalendar(2013, Calendar.JULY, 13).getTime());
        manager.register(cookedOne);

        CookedOrderEventDataRow cookedTwo = new CookedOrderEventDataRow("Планшет №34", "Николай", 28 * 60, dishes);
        cookedTwo.setCurrentDate(new GregorianCalendar(2013, Calendar.JULY, 14).getTime());
        manager.register(cookedTwo);

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printCookWorkloading();

        //14-Jul-2013
        //Ivanov - 60 min
        //Petrov - 35 min
        //
        //13-Jul-2013
        //Ivanov - 129 min
        //
        //12-Jul-2013
        //Ivanov - 6 min
        //Petrov - 5 min

    }

    @Test
    public void testActiveAdvertisementList() {

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        System.out.println("========================");
        directorTablet.printArchivedVideoSet();
    }

    @Test
    public void testInitDishes() {
//        try {
//            TestOrder test = new TestOrder(new Tablet(1));
//            test.getDishes().forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        RandomOrderGeneratorTask task = new RandomOrderGeneratorTask();
//        task.run();
    }
}