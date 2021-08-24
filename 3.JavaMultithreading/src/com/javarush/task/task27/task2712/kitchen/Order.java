package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Класс заказа.
 */
public class Order {

    // Планшет
    private final Tablet tablet;

    // Список выбранных блюд
    protected List<Dish> dishes;

    /**
     * Конструктор заказа.
     *
     * @param tablet Планшет.
     */
    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    /**
     * Геттер планшета.
     *
     * @return Планшет.
     */
    public Tablet getTablet() {
        return tablet;
    }


    /**
     * Геттер списка выбранных блюд.
     *
     * @return Выбранные блюда.
     */
    public List<Dish> getDishes() {
        return dishes;
    }

    /**
     * Метод проверяет есть ли заказы.
     *
     * @return Возвращает true, если заказов нет.
     */
    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    /**
     * Метод подсчитывает время для приготовления заказа.
     *
     * @return Время приготовления заказа.
     */
    public int getTotalCookingTime() {
        return dishes.stream()
                .mapToInt(Dish::getDuration)
                .sum();
    }

    /**
     * Переопределенный метод. Пример возврата строки.
     * Your order: [JUICE, FISH] of Tablet{number=5}, cooking time 23min
     *
     * @return Возвращает заказ или пустую строку при отсутствии блюд.
     */
    @Override
    public String toString() {
        if (dishes.isEmpty()) {
            return "";
        }

        return String.format("Your order: %s of %s, cooking time %dmin", dishes, tablet, getTotalCookingTime());
    }
}

