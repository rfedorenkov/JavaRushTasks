package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Класс повара. Готовит заказы.
 * Получает заказ от менеджера заказов.
 * После приготовления заказа уведомляет официанта.
 * Является наблюдаемым (Observable) и Consumer, т.к. обрабатывает заказы.
 */
public class Cook implements Runnable {

    // Имя повара
    private final String name;

    // Занятость повара
    private boolean busy;

    // Очередь заказов
    private LinkedBlockingQueue<Order> queue;
    // Очередь приготовленных заказов
    private LinkedBlockingQueue<Order> cookedQueue;

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
     * Сеттер очереди заказа, устанавливается
     * при создании объекта в классе Restaurant
     *
     * @param queue Очередь заказов
     */
    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    /**
     * Сеттер очереди заказа, устанавливается
     * при создании объекта в классе Restaurant
     *
     * @param queue Очередь заказов
     */
    public void setCookedQueue(LinkedBlockingQueue<Order> queue) {
        this.cookedQueue = queue;
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
        // Устанавливаем повара, который готовит заказ
        order.setCook(this);

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
        cookedQueue.add(order);

        // Повар приготовил заказ и переводим повара в состояние "Свободен"
        busy = false;
    }

    /**
     * Метод возвращает имя повара.
     *
     * @return Имя повара.
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Метод берез из очереди заказ и готовит его.
     */
    @Override
    public void run() {
        while (true) {
            try {
                // Если очередь не пуста
                if (!queue.isEmpty()) {
                    if (!this.isBusy()) {
                        // Берем заказ из очереди
                        startCookingOrder(queue.take());
                    }
                }
                Thread.sleep(10);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
