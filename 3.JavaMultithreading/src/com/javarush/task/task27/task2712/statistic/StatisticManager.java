package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс менеджера статистики.
 * Отвечает за регистрацию событий в хранилище.
 * Класс является Singleton, поскольку относится ко всему ресторану.
 */
public enum StatisticManager {
    INSTANCE;

    // Хранилище статистики
    private StatisticStorage statisticStorage = new StatisticStorage();

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

    }

    /**
     * Внутренний приватный класс, который отвечает
     * за хранение статистики.
     */
    private class StatisticStorage {
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
    }
}