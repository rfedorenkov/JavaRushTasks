package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Класс менеджера заказов.
 */
public class OrderManager implements Observer {

    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    /**
     * Метод складывает заказ в очередь.
     *
     * @param tablet Объект, который отправил нам заказ.
     * @param obj    Заказ.
     */
    @Override
    public void update(Observable tablet, Object obj) {
        if (obj instanceof Order) {
            Order order = (Order) obj;
            orderQueue.add(order);
        }
    }
}
