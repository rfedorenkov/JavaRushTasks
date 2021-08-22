package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Enum со списком блюд.
 */
public enum Dish {

    /**
     * Рыба, время приготовления 25 минут
     */
    FISH(25),

    /**
     * Стейк, время приготовления 30 минут
     */
    STEAK(30),

    /**
     * Суп, время приготовления 15 минут
     */
    SOUP(15),

    /**
     * Сок, время приготовления 5 минут
     */
    JUICE(5), // сок

    /**
     * Вода, время приготовления 3 минуты
     */
    WATER(3);

    // Время приготовления в минутах
    private int duration;

    /**
     * Конструктор блюда.
     *
     * @param duration Время приготовления.
     */
    Dish(int duration) {
        this.duration = duration;
    }

    /**
     * Геттер время приготовления блюда.
     *
     * @return Возвращает время приготовления блюда.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Метод сформировывает строку из всех доступных блюд.
     *
     * @return Возвращает сформированную строку динамически.
     */
    public static String allDishesToString() {
        StringJoiner result = new StringJoiner(", ");
        Arrays.stream(values()).map(Enum::toString).forEach(result::add);
        return result.toString();
    }
}