package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Тестовый класс заказа.
 */
public class TestOrder extends Order {

    /**
     * Конструктор заказа.
     *
     * @param tablet Планшет.
     */
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        dishes = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(10); i++) {
            int number = random.nextInt(Dish.values().length);
            dishes.add(Dish.values()[number]);
        }
    }
}
