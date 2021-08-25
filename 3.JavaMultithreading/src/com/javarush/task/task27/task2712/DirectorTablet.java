package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

/**
 * Класс планшета директора ресторана.
 */
public class DirectorTablet {

    /**
     * Метод выводит какую сумму заработали на рекламе.
     * Сгруппированно по дням.
     */
    public void printAdvertisementProfit() {
        // Печатаем в консоль общую статистику по рекламным роликам
        StatisticManager.getInstance()
                .getAdvertisementProfitMap()
                .forEach((date, amount) -> System.out.printf(Locale.ENGLISH, "%s - %.2f%n", date, amount));
    }

    /**
     * Метод выводит загрузку (рабочее время) повара.
     * Сгруппированно по дням.
     */
    public void printCookWorkloading() {
        StatisticManager.getInstance().getCookWorkLoadingMap().forEach((key, value) -> {
            System.out.println(key);
            for (Map.Entry<String, Integer> cooks : value.entrySet()) {
                System.out.printf("%s - %d min%n", cooks.getKey(), cooks.getValue());
            }
            System.out.println();
        });
    }

    /**
     * Метод выводит список активных роликов и оставшееся
     * количество оставшееся количество показов ролика.
     */
    public void printActiveVideoSet() {
        StatisticAdvertisementManager.getInstance()
                .getActiveAdvertisementList(true)
                .forEach(ad -> System.out.printf("%s - %d%n", ad.getName(), ad.getHits()));
    }

    /**
     * Метод выводит список неактивных роликов.
     */
    public void printArchivedVideoSet() {
        StatisticAdvertisementManager.getInstance()
                .getActiveAdvertisementList(false)
                .forEach(ad -> System.out.println(ad.getName()));
    }
}