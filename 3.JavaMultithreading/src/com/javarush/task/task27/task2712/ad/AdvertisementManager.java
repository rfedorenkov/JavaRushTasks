package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * Конструктор класса.
     *
     * @param timeSeconds Время выполнения заказа в секундах.
     */
    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    /**
     * Геттер лучшего списка рекламных роликов.
     *
     * @return Лучший список рекламных роликов.
     */
    public List<Advertisement> getBestAdList() {
        return bestAdList;
    }

    /**
     * Метод выводит на экран отсортированный список рекламных роликов.
     */
    public void printSortedBestAd() {
        // Сортируем список
        Collections.sort(bestAdList);

        bestAdList.forEach(advertisement -> {
            // Выводим в консоль
            ConsoleHelper.writeMessage(advertisement);
            // Уменьшаем количество показов
            advertisement.revalidate();
        });
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

//        makeAllSets(activeList(storage.list()));
//        printSortedBestAd();

        // Формируем список по ревелантности рекламных роликов
        makeAdvertisementList(storage.list());
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
    }


    /**
     * Рекурсивное решение задачи.
     * Создание всех наборов перестановок значений.
     *
     * @param list Список предметов.
     */
    public void makeAllSets(List<Advertisement> list) {
        // Проверяем, является ли данный список лучшим решением
        if (list.size() > 0) {
            checkSet(list);
        }

        // Проходимся циклом по всему списку предметов
        for (int i = 0; i < list.size(); i++) {
            // Создаем новый список на основе имеющегося
            List<Advertisement> newItems = new ArrayList<>(list);
            newItems.remove(i);
            makeAllSets(newItems);
        }
    }

    private List<Advertisement> activeList(List<Advertisement> list) {
        return list.stream()
                .filter(Advertisement::isActive)
                .collect(Collectors.toList());
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

    /**
     * Проверяем, является ли данный список лучшим решением.
     *
     * @param list Список рекламных роликов.
     */
    private void checkSet(List<Advertisement> list) {
        // Сравниваем продолжительность ролика с максимальной продолжительностью
        // и стоимость рекламных роликов с лучшей ценой
        if (calculateDuration(list) <= timeSeconds && calculatePrice(list) > bestPrice) {
            bestAdList = list;
            bestPrice = calculatePrice(list);
        }
    }
}