package com.javarush.task.task27.task2712.statistic.event;

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
}
