package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Основной класс ресторана.
 * Данный класс создан для автоматизации работы в ресторане.
 *
 * Задание.
 * Директор ресторана хочет, чтобы:
 * 1) На каждом столике лежал планшет, через который можно было бы сделать заказ;
 * 2) Пока заказ готовится, на планшете показывалась реклама;
 * 3) В конце рабочего дня была возможность посмотреть различную статистику:
 * - загрузки повара;
 * - сумму выручки за заказы;
 * - сумму выручки за показы рекламы.
 *
 * В данной задаче разрабатывается ядро, без UI (User Interface).
 *
 * Что нужно реализовать:
 * 1.1) Созданный посетителем заказ будет автоматически поступать к повару;
 * 1.2) Повар будет готовить его какое-то время и отмечать приготовленным;
 * 1.3) После этого официант будет относить его.
 *
 * 2.1) Подобрать нужные рекламные ролики из списка оплаченных;
 * 2.2) Отображать рекламные ролики во время приготовления заказа;
 * 2.3) Максимизировать прибыль от показа рекламы.
 *
 * 3.1) Подсчитывает статистику;
 * 3.2) Отображает статистику директору.
 */
public class Restaurant {
    // Интервал создания заказа
    private static final int ORDER_CREATING_INTERVAL = 100;

    // Очередь заказов
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();

    // Очередь приготовленных заказов
    private static final LinkedBlockingQueue<Order> COOKED_ORDER_QUEUE = new LinkedBlockingQueue<>();

    /**
     * Главный метод класса.
     * Запускает работу ресторана.
     */
    public static void main(String[] args) {

        // Создаем повара
        Cook firstCook = new Cook("Amigo");
        Cook secondCook = new Cook("Ellie");

        // Устанавливаем очередь заказов
        firstCook.setQueue(ORDER_QUEUE);
        secondCook.setQueue(ORDER_QUEUE);
        firstCook.setCookedQueue(COOKED_ORDER_QUEUE);
        secondCook.setCookedQueue(COOKED_ORDER_QUEUE);

        // Создаем список из 5 планшетов
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(ORDER_QUEUE);
            tablets.add(tablet);
        }

        // Создаем официанта
        Waiter waiter = new Waiter();
        waiter.setQueue(COOKED_ORDER_QUEUE);
        // Создаем поток официанта
        Thread waiterThread = new Thread(waiter);
        waiterThread.setDaemon(true);
        waiterThread.start();

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();

        // Создаем 2 потока, делаем их daemon и запускаем их
        Thread firstCookThread = new Thread(firstCook);
        firstCookThread.setDaemon(true);
        firstCookThread.start();

        Thread secondCookThread = new Thread(secondCook);
        secondCookThread.setDaemon(true);
        secondCookThread.start();

        // Ждем 1 секунду и прерываем
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) {
        }

        thread.interrupt();


        // Создаем планшет директора
        DirectorTablet directorTablet = new DirectorTablet();
        // Выводим статистику
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
        directorTablet.printNoAvailableVideoSet();

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

