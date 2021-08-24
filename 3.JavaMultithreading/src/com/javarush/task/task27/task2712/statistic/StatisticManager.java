package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

/**
 * Класс менеджера статистики.
 * Отвечает за регистрацию событий в хранилище.
 * Класс является Singleton, поскольку относится ко всему ресторану.
 */
public enum StatisticManager {
    INSTANCE;

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
}