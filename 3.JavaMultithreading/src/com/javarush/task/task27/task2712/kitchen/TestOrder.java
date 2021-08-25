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

    //г) переопредели initDishes в классе-наследнике TestOrder:
    // проинициализируй поле dishes пустым списком и заполни его случайным набором блюд;

}


//Ресторан(18)
//Сейчас у нас один планшет и 1 повар.
//Давай создадим несколько планшетов, которые будут рандомно генерировать заказы, и сделаем два повара.
//


//В классе Tablet создай метод void createTestOrder()
// с похожей функциональностью, который будет случайным образом генерировать заказ
// со случайными блюдами не общаясь с реальным человеком.
//Список планшетов и интервал передай в конструкторе RandomOrderGeneratorTask.
//
//Подсказка:
//г) переопредели initDishes в классе-наследнике TestOrder:
// проинициализируй поле dishes пустым списком и заполни его случайным набором блюд;
//

//
//Requirements:
//4. Класс TestOrder должен быть реализован в соответствии с условием задачи.
//5. Класс RandomOrderGeneratorTask должен быть реализован в соответствии с условием задачи.
