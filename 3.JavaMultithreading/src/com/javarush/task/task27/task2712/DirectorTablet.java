package com.javarush.task.task27.task2712;

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
                .forEach((date, amount) ->
                        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", date, amount)));

    }

    /**
     * Метод выводит загрузку (рабочее время) повара.
     * Сгруппированно по дням.
     */
    public void printCookWorkloading() {
        StatisticManager.getInstance().getCookWorkLoadingMap().forEach((key, value) -> {
            ConsoleHelper.writeMessage(key);
            for (Map.Entry<String, Integer> cooks : value.entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", cooks.getKey(), cooks.getValue()));
            }
            ConsoleHelper.writeMessage("");
        });
    }

    /**
     * Метод выводит список активных роликов и оставшееся
     * количество оставшееся количество показов ролика.
     */
    public void printActiveVideoSet() {
        StatisticAdvertisementManager.getInstance()
                .getAdvertisementList(true)
                .forEach(ad -> ConsoleHelper.writeMessage(String.format("%s - %d", ad.getName(), ad.getHits())));
    }

    /**
     * Метод выводит список неактивных роликов.
     */
    public void printArchivedVideoSet() {
        StatisticAdvertisementManager.getInstance()
                .getAdvertisementList(false)
                .forEach(ad -> ConsoleHelper.writeMessage(ad.getName()));
    }
}