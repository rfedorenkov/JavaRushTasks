package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс генератора случайных заказов.
 */
public class RandomOrderGeneratorTask implements Runnable {
    // Список всех планшетов
    private List<Tablet> tablets;
    // Интервал создания заказа
    private final int orderCreatingInterval;

    /**
     * Конструктор класса.
     *
     * @param tablets               Список планшетов.
     * @param orderCreatingInterval Интервал создания заказа.
     */
    public RandomOrderGeneratorTask(List<Tablet> tablets, int orderCreatingInterval) {
        this.tablets = tablets;
        this.orderCreatingInterval = orderCreatingInterval;
    }

    @Override
    public void run() {
        while (true) {
            int id = (int) (Math.random() * tablets.size());
            Tablet tablet = tablets.get(id);
            tablet.createTestOrder();
            try {
                Thread.sleep(orderCreatingInterval);
            } catch (InterruptedException ignored) {
            }
        }
    }
}