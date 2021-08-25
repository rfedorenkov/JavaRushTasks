package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;

/**
 * Класс повара. Готовит заказы.
 * Получает заказ от менеджера заказов.
 * После приготовления заказа уведомляет официанта. Является наблюдаемым (Observable).
 */
public class Cook extends Observable {
    // Имя повара
    private final String name;

    // Занятость повара
    private boolean busy;

    /**
     * Конструктор повара.
     *
     * @param name Имя повара.
     */
    public Cook(String name) {
        this.name = name;
    }

    /**
     * Метод проверяет занят ли повар.
     *
     * @return Если повар занят - true.
     */
    public boolean isBusy() {
        return busy;
    }


    /**
     * Метод начинает приготовление заказа.
     * Уведомляет официанта о готовности заказа.
     *
     * @param order Заказ.
     */
    public void startCookingOrder(Order order) {
        // Принимаем заказ и переводим повара в состояние "Занят"
        busy = true;

        // Выводим в консоль заказ
        ConsoleHelper.writeMessage(String.format("Start cooking - %s", order));

        try {
            // Имитация задержки приготовления
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException ignored) {

        }

        // Регистрируем событие "Повар приготовил заказ"
        StatisticManager.getInstance()
                .register(new CookedOrderEventDataRow(order.getTablet().toString(),
                        name, order.getTotalCookingTime() * 60, order.dishes));

        // Оповещаем официанта
        setChanged();
        notifyObservers(order);

        // Повар приготовил заказ и переводим повара в состояние "Свободен"
        busy = false;
    }

    @Override
    public String toString() {
        return name;
    }
}
