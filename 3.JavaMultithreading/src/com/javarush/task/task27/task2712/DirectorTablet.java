package com.javarush.task.task27.task2712;

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
     * количество показов по каждому.
     */
    public void printActiveVideoSet() {
    }

    /**
     * Метод выводит список неактивных роликов.
     * Количество показов равно нулю.
     */
    public void printArchivedVideoSet() {

    }
}