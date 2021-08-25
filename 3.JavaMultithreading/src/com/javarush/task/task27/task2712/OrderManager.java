package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Класс менеджера заказов.
 */
public class OrderManager implements Observer {

    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    /**
     * Конструктор класса.
     * Запускает daemon поток.
     */
    public OrderManager() {
        new DaemonManagerThread().start();
    }

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

    /**
     * Класс daemon потока, который проверяет наличие
     * заказов в очереди, берет свободных поваров и отдает им заказы.
     */
    private class DaemonManagerThread extends Thread {

        /**
         * Конструктор daemon потока.
         */
        private DaemonManagerThread() {
            setDaemon(true);
        }

        /**
         * Метод получает заказ из очереди, ищет доступных поваров,
         * проверяет, что повар свободен и передает ему заказ.
         */
        @Override
        public void run() {
            while (true) {
                try {
                    // Если очередь не пуста
                    if (!orderQueue.isEmpty()) {
                        // Получаем список доступных поваров
                        Set<Cook> cooks = StatisticManager.getInstance().getCooks();
                        // Проходимся по всем поварам
                        for (Cook cook : cooks) {
                            // Если повар не занят
                            if (!cook.isBusy()) {
                                // Берем заказ из очереди
                                cook.startCookingOrder(orderQueue.take());
                            }
                        }
                    }
                    sleep(10);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }
}