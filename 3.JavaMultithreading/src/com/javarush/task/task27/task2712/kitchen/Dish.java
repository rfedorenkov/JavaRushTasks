package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Enum со списком блюд.
 */
public enum Dish {
    FISH, // рыба
    STEAK, // стейк
    SOUP, // суп
    JUICE, // сок
    WATER // вода
    ;

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