package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс планшета. Создает заказы.
 * После получения заказа, передает повару.
 */
public class Tablet {
    // Логгер
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    // Номер планшета
    private final int number;
    // Очередь заказов
    private LinkedBlockingQueue<Order> queue;

    /**
     * Конструктор планшета.
     *
     * @param number Принимает номер планшета.
     */
    public Tablet(int number) {
        this.number = number;
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
     * Тестовый метод.
     * Метод создает заказ из случайных блюд.
     */
    public void createTestOrder() {
        try {
            // Создаем текстовый заказ
            Order order = new TestOrder(this);
            // Если в заказе блюда есть, отправляем повару
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    /**
     * Метод создает заказ из тех блюд, которые выберет пользователь.
     */
    public void createOrder() {
        try {
            // Создаем заказ
            Order order = new Order(this);
            // Если в заказе блюда есть, отправляем повару
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    /**
     * Метод отправляет повару заказ, а так же
     * показываем рекламное видео.
     *
     * @param order Заказ.
     */
    private void processOrder(Order order) {
        // Если в заказе блюда есть, отправляем повару
        if (!order.isEmpty()) {
            // Выводим в консоль заказ
            ConsoleHelper.writeMessage(order.toString());

            // Рекламное видео
            try {
                // Получаем время выполнения заказа в секундах
                int totalCookingTimeInSeconds = order.getTotalCookingTime() * 60;
                // Создаем менеджера рекламы
                AdvertisementManager manager = new AdvertisementManager(totalCookingTimeInSeconds);
                // Обрабатываем рекламное видео
                manager.processVideos();
            } catch (NoVideoAvailableException e) {
                // Перхватываем и логируем исключение
                String message = e.getMessage();
                logger.log(Level.INFO, message + order);
                StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(order.getTotalCookingTime()));
            }

            // Оповещаем повара о заказе
            queue.add(order);
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}

