package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Класс официанта.
 * Получает заказ от повара. Является наблюдателем (Observer)
 */
public class Waiter implements Observer {

    /**
     * Метод обрабатывает заказы.
     *
     * @param cook Объект, который отправил нам заказ.
     * @param order Заказ.
     */
    @Override
    public void update(Observable cook, Object order) {
        // Выводим в консоль заказ
        ConsoleHelper.writeMessage(String.format("%s was cooked by %s", order, cook));
    }
}



