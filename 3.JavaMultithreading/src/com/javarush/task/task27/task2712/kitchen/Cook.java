package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Класс повара. Готовит заказы.
 * Получает заказ с планшета. Является наблюдателем (Observer)
 * После приготовления заказа уведомляет официанта. Является наблюдаемым (Observable).
 */
public class Cook extends Observable implements Observer {
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
     * @param tablet Объект, который отправил нам заказ.
     * @param order Заказ.
     */
    @Override
    public void update(Observable tablet, Object order) {
        // Выводим в консоль заказ
        ConsoleHelper.writeMessage(String.format("Start cooking - %s", order));
        // Оповещаем официанта
        setChanged();
        notifyObservers(order);
    }
}
