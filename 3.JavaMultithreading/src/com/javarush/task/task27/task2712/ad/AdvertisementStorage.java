package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс является хранилищем рекламных роликов.
 * Класс является Singleton, поскольку относится ко всему ресторану.
 */
public enum AdvertisementStorage {
    STORAGE;

    // Список рекламных роликов
    private final List<Advertisement> videos = new ArrayList<>();

    /**
     * Конструктор класса.
     */
    AdvertisementStorage() {
        // Создем некий объект
        Object someContent = new Object();

        // Создаем 3 рекламных ролика
        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));
    }

    /**
     * Метод возвращает хранилище рекламных роликов.
     *
     * @return Возвращаем хранилище.
     */
    public static AdvertisementStorage getInstance() {
        return STORAGE;
    }

    /**
     * Метод возвращает список всех существующих доступных видео.
     *
     * @return Возвращает список видео.
     */
    public List<Advertisement> list() {
        return videos;
    }

    /**
     * Метод добавляет новое видео в список videos.
     *
     * @param advertisement Рекламное видео.
     */
    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
