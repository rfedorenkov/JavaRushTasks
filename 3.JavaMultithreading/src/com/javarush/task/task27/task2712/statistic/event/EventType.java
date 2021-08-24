package com.javarush.task.task27.task2712.statistic.event;

/**
 * Класс событий.
 */
public enum EventType {

    /**
     * Повар приготовил заказ
     */
    COOKED_ORDER,

    /**
     * Выбрали набор видео-роликов для заказа
     */
    SELECTED_VIDEOS,

    /**
     * Нет ни одного видео-ролика, который можно показать во время приготовления заказа
     */
    NO_AVAILABLE_VIDEO

}
