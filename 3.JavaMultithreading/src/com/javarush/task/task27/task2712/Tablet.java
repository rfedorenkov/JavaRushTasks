package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс планшета.
 */
public class Tablet {
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
    }

    /**
     * Метод создает заказ из тех блюд, которые выберет пользователь.
     */
    public void createOrder() {
        try {
            Order order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}