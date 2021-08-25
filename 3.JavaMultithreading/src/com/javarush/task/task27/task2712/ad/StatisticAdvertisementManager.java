package com.javarush.task.task27.task2712.ad;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс менеджера рекламной статистики.
 * Предоставляет информацию из AdvertisementStorage в нужном виде.
 * Класс является Singleton, поскольку относится ко всему ресторану.
 */
public enum StatisticAdvertisementManager {
    INSTANCE;

    private final AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    /**
     * Метод возвращает менеджера статистики.
     *
     * @return Менеджер статистики.
     */
    public static StatisticAdvertisementManager getInstance() {
        return INSTANCE;
    }

    /**
     * Метод возвращает отсортированный по алфавиту (без учета регистра)
     * список активных или архивированных рекламных роликов в зависимости от переданного параметра.
     *
     * @param isActive Активный ролик - true, Архивный - false.
     * @return Отсортированный список рекламных роликов в зависимости от переданного параметра.
     */
    public List<Advertisement> getAdvertisementList(boolean isActive) {
        return advertisementStorage.list()
                .stream()
                .filter(advertisement -> isActive == advertisement.isActive())
                .sorted(Comparator.comparing(ad -> ad.getName().toLowerCase()))
                .collect(Collectors.toList());
    }
}