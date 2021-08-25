package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Класс официанта.
 * Получает заказ от повара. Является наблюдателем (Observer)
 */
public class Waiter implements Runnable {

    // Очередь приготовленных заказов
    private LinkedBlockingQueue<Order> queue;

    /**
     * Метод обрабатывает заказы.
     */
    @Override
    public void run() {
        while (true) {
            try {
                // Если очередь не пуста
                if (!queue.isEmpty()) {
                    // Берем заказ из очереди
                    Order order = queue.take();
                    ConsoleHelper.writeMessage(String.format("%s was cooked by %s", order.getDishes(), order.getCook()));
                }
                Thread.sleep(10);
            } catch (InterruptedException ignored) {
            }
        }
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
}
//Ресторан(23)
//Это всё! Красоту можешь наводить самостоятельно.
//
//Например:
//1. Сделай Waiter таском, чтобы он работал как трэд (убери Observer).
// Сделай очередь приготовленных заказов, официант пусть берет заказы из нее и относит на столы.
//2. Запиши в ивент-лог событие NoAvailableVideoEventDataRow тогда,
// когда невозможно подобрать видео. Выдавай это событие директору.
//3. Напиши UI, например, на Swing.
//
//Твои достижения:
//1. Разобрался с паттерном Observer.
//2. Прокачал скилл написания рекурсии.
//3. Познакомился с методом реализации ведения статистики.
//4. Стал больше знать и уметь.
//5. Увидел, как раскладывать задачу на подзадачи.
//6. Продвинулся на шаг ближе к работе джава программистом.
//
//Поздравляю!
//
//
//Requirements:
//1. Ты отлично поработал. Большая задача пройдена!



