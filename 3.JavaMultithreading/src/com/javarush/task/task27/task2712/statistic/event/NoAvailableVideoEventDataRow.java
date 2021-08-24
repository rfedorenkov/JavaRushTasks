package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * Класс отвечающий за событие, когда нет рекламных роликов, которые можно
 * показать во время приготовления заказа.
 */
public class NoAvailableVideoEventDataRow implements EventDataRow {

    // Время приготовления заказа в секундах
    private int totalDuration;

    // Текущая дата
    private Date currentDate = new Date();

    /**
     * Конструктор класса.
     *
     * @param totalDuration Время приготовления заказа в секундах.
     */
    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    /**
     * Метод возвращает тип события.
     *
     * @return Тип события - Нет доступных видео.
     */
    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }

    /**
     * Метод возвращает дату создания события.
     *
     * @return Дата создания события.
     */
    @Override
    public Date getDate() {
        return currentDate;
    }

    /**
     * Метод возвращает время приготовления заказа.
     *
     * @return Время приготовления заказа в секундах.
     */
    @Override
    public int getTime() {
        return totalDuration;
    }
}


