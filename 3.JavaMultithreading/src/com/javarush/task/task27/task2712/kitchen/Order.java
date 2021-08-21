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
     * @param tablet Принимает планшет.
     */
    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    /**
     * Переопределенный метод. Пример возврата строки.
     * Your order: [JUICE, FISH] of Tablet{number=5}
     *
     * @return Возвращает заказ или пустую строку при отсутствии блюд.
     */
    @Override
    public String toString() {
        if (dishes.isEmpty()) {
            return "";
        }

        return String.format("Your order: %s of %s", dishes, tablet);
    }
}

