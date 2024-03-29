package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Date;
import java.util.List;

/**
 * Класс отвечающий за событие показа набора видео-роликов для заказа.
 */
public class VideoSelectedEventDataRow implements EventDataRow {

    // Список видео-роликов, отобранных для показа
    private List<Advertisement> optimalVideoSet;
    // Сумма денег в копейках
    private long amount;
    // Общая продолжительность показа отобранных рекламных роликов
    private int totalDuration;

    // Текущая дата
    private Date currentDate = new Date();

    /**
     * Конструктор класса.
     *
     * @param optimalVideoSet Список видео-роликов, отобранных для показа.
     * @param amount Сумма денег в копейках.
     * @param totalDuration Общая продолжительность показа отобранных рекламных роликов.
     */
    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
    }

    /**
     * Метод возвращает сумму денег в копейках.
     *
     * @return Сумма денег в копейках.
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Метод возвращает тип события.
     *
     * @return Тип события - Показ рекламных роликов.
     */
    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
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
     * Метод возвращает общую продолжительность показа
     * отобранных рекламных роликов.
     *
     * @return Общая продолжительность рекламных роликов.
     */
    @Override
    public int getTime() {
        return totalDuration;
    }

    @Override
    public String toString() {
        return "VideoSelectedEventDataRow{" +
                "optimalVideoSet=" + optimalVideoSet +
                '}';
    }
}

