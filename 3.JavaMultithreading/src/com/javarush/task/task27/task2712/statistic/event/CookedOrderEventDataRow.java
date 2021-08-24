package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.util.Date;
import java.util.List;

/**
 * Класс отвечающий за событие приготовления заказа.
 */
public class CookedOrderEventDataRow implements EventDataRow {

    // Имя планшета
    private String tabletName;
    // Имя повара
    private String cookName;
    // Время приготовления заказа в секундах
    private int cookingTimeSeconds;
    // Список блюд для приготовления
    private List<Dish> cookingDishes;

    // Текущая дата
    private Date currentDate = new Date();

    /**
     * Конструктор класса.
     *
     * @param tabletName Имя планшета.
     * @param cookName Имя повара.
     * @param cookingTimeSeconds Время приготовления заказа в секундах.
     * @param cookingDishes Список блюд для приготовления.
     */
    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishes) {

        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishes = cookingDishes;
    }

    /**
     * Метод возвращает тип события.
     *
     * @return Тип события - Приготовление заказа.
     */
    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }

}