package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Класс повара.
 * Готовит заказы. Является наблюдателем (Observer)
 */
public class Cook implements Observer {
    // Имя повара
    private final String name;

    /**
     * Конструктор повара.
     *
     * @param name Имя повара.
     */
    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Метод обрабатывает заказы.
     *
     * @param o Объект, который отправил нам заказ.
     * @param order Заказ.
     */
    @Override
    public void update(Observable o, Object order) {
        ConsoleHelper.writeMessage(String.format("Start cooking - %s", order));
    }
}


