package com.javarush.task.task27.task2712;

import java.util.List;

/**
 * Класс генератора случайных заказов.
 * Является Producer, т.к. производит заказы.
 */
public class RandomOrderGeneratorTask implements Runnable {
    // Список всех планшетов
    private List<Tablet> tablets;
    // Интервал создания заказа
    private final int interval;

    /**
     * Конструктор класса.
     *
     * @param tablets  Список планшетов.
     * @param interval Интервал создания заказа.
     */
    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            // Получаем случайный сгенерированный id номер
            int id = (int) (Math.random() * tablets.size());
            // Получаем объект по id и вызываем createTestOrder
            tablets.get(id).createTestOrder();

            try {
                // Ожидаем в пределах указанного интервала
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                // Если было исключение, то повторно прерываем
                Thread.currentThread().interrupt();
            }
        }
    }
}