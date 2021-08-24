package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.*;

/**
 * Класс менеджера статистики.
 * Отвечает за регистрацию событий в хранилище.
 * Класс является Singleton, поскольку относится ко всему ресторану.
 */
public enum StatisticManager {
    INSTANCE;

    // Хранилище статистики
    private StatisticStorage statisticStorage = new StatisticStorage();

    // Список поваров
    private Set<Cook> cooks = new HashSet<>();

    /**
     * Метод возвращает менеджера статистики.
     *
     * @return Менеджер статистики.
     */
    public static StatisticManager getInstance() {
        return INSTANCE;
    }

    // подсчет статистики

    // отображение статистики директору

    /**
     * Метод регистрирует событие в хранилище
     *
     * @param data Событие.
     */
    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    /**
     * Метод регистрирует повара (добавляет в Set)
     *
     * @param cook Повар.
     */
    public void register(Cook cook) {
        cooks.add(cook);
    }

    /**
     * Внутренний приватный класс, который отвечает
     * за хранение статистики.
     */
    private class StatisticStorage {
        // Хранилище
        private Map<EventType, List<EventDataRow>> storage;

        /**
         * Конструктор класса.
         * Инициализирует Map storage и заполняет данными.
         */
        private StatisticStorage() {
            this.storage = new HashMap<>();
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<>());
            }
        }

        /**
         * Метод добавляет в данные в хранилище.
         *
         * @param data Данные.
         */
        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }
    }
}

