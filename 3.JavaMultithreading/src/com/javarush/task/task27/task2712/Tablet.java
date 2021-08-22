package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс планшета. Создает заказы.
 * После получения заказа, передает повару. Является наблюдаемым (Observable)
 */
public class Tablet extends Observable {
    // Логгер
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    // Номер планшета
    private final int number;

    /**
     * Конструктор планшета.
     *
     * @param number Принимает номер планшета.
     */
    public Tablet(int number) {
        this.number = number;
        ConsoleHelper.writeMessage("Здавствуйте!");
    }

    /**
     * Метод создает заказ из тех блюд, которые выберет пользователь.
     */
    public Order createOrder() {
        try {
            Order order = new Order(this);
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
                }

                // Оповещаем повара о заказе
                setChanged();
                notifyObservers(order);
            }
            return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        }
        // возможно перенести return Order в finally
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}

