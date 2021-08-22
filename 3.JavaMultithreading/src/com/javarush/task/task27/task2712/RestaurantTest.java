package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantTest {

    @Test
    public void dishTestString() {
        Assert.assertEquals("FISH, STEAK, SOUP, JUICE, WATER", Dish.allDishesToString());
        ConsoleHelper.writeMessage("Dish Test String - Well Done");
    }

    @Test
    public void advertisementDivisionByZero() {
        try {
            new Advertisement(new Object(), "Test", 100, 0, 20);
            ConsoleHelper.writeMessage("Advertisement Test Division / 0 - Well Done");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testSortVideos() {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(Dish.WATER);

//     * @param content Видео.
//     * @param name Имя / название.
//     * @param initialAmount Начальная сумма, стоимость рекламы в копейках.
//     * @param hits Количество оплаченных показов.
//     * @param duration Продолжительность в секундах.
//        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));
//        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));
//        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));

        int totalTime = dishes.stream()
                .mapToInt(Dish::getDuration)
                .sum();

        AdvertisementManager advertisementManager = new AdvertisementManager(totalTime);
        advertisementManager.processVideos();
    }
}