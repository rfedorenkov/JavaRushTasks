package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * Интерфейс-маркер.
 * Проверяется является ли переданный объект событием.
 */
public interface EventDataRow {

    /**
     * Метод возвращает тип события.
     *
     * @return Тип события.
     */
    EventType getType();


    /**
     * Метод возвращает дату создания события.
     *
     * @return Дата создания события.
     */
    Date getDate();

    /**
     * Метод возвращает время или продолжительность.
     *
     * @return Время или продолжительность.
     */
    int getTime();
}