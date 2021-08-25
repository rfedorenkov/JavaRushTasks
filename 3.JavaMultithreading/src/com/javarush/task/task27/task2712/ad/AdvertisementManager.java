package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс менеджера рекламы.
 * У каждого планшета будет свой объект менеджера, который будет
 * подбирать оптимальный набор роликов и их последовательность для каждого заказа.
 * Так же будет взаимодействовать с плеером и отображать ролики.
 */
public class AdvertisementManager {
    // Хранилище рекламных роликов
    private final AdvertisementStorage storage = AdvertisementStorage.STORAGE;

    // Время выполнения заказа секундах
    private int timeSeconds;

    // Лучшие список рекламных роликов
    private List<Advertisement> bestAdList = new ArrayList<>();
    // Лучшая цена рекламных роликов
    private long bestPrice;
    // Лучшая продолжительность рекламных роликов
    private int maxDuration;

    /**
     * Конструктор класса.
     *
     * @param timeSeconds Время выполнения заказа в секундах.
     */
    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    /**
     * Метод выводит на экран список рекламных роликов.
     */
    public void printBestAd() {
        bestAdList.forEach(advertisement -> {
            // Выводим в консоль
            ConsoleHelper.writeMessage(advertisement);
            // Уменьшаем количество показов
            advertisement.revalidate();
        });
    }

    /**
     * Метод обрабатывает рекламное видео.
     * Метод подбирает список видео из доступных, просмотр которых
     * обеспечивает максимальную выгоду.
     *
     * @throws NoVideoAvailableException Если нет видео с рекламой.
     */
    public void processVideos() throws NoVideoAvailableException {
        // Если нет рекламных видео, то бросаем исключение
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException("No video is available for the order ");
        }

        // Формируем список по ревелантности рекламных роликов
        makeAdvertisementList(storage.list());

        // Регистрируем событие "видео выбрано"
        StatisticManager.getInstance()
                .register(new VideoSelectedEventDataRow(bestAdList, bestPrice, maxDuration));

        // Выводим в консоль список доступных роликов
        printBestAd();
    }

    /**
     * Решение задачи с помощью "Жадного алгоритма".
     * Создание всех наборов перестановок значений.
     *
     * @param list Список предметов.
     */
    public void makeAdvertisementList(List<Advertisement> list) {
        ArrayList<Advertisement> copyList = new ArrayList<>(list);
        Collections.sort(copyList);
        for (Advertisement advertisement : copyList) {
            int duration = advertisement.getDuration();
            if (advertisement.isActive() && duration <= timeSeconds) {
                bestAdList.add(advertisement);
                timeSeconds -= duration;
            }
        }
        bestPrice = calculatePrice(bestAdList);
        maxDuration = calculateDuration(bestAdList);
    }

    /**
     * Считаем суммарную продолжительность рекламных роликов.
     *
     * @param list Список рекламных роликов.
     * @return Суммарная продолжительность рекламных роликов.
     */
    private int calculateDuration(List<Advertisement> list) {
        return list.stream()
                .mapToInt(Advertisement::getDuration)
                .sum();
    }

    /**
     * Считаем суммарную стоимость рекламных роликов.
     *
     * @param list Список рекламных роликов.
     * @return Суммарная стоимость рекламных роликов.
     */
    private long calculatePrice(List<Advertisement> list) {
        return list.stream()
                .mapToLong(Advertisement::getAmountPerOneDisplaying)
                .sum();
    }
}