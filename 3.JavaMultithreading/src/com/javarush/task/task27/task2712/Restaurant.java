package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;

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
 *
 */
public class Restaurant {
    // Интервал создания заказа
    private static final int ORDER_CREATING_INTERVAL = 100;

    /**
     * Главный метод класса.
     * Запускает работу ресторана.
     */
    public static void main(String[] args) {
//        // Создаем повара
//        Cook cook = new Cook("Amigo");
//
//        // Создаем официанта
//        Waiter waiter = new Waiter();
//
//        // Создаем планшет и присваиваем ему номер
//        Tablet tablet = new Tablet(5);
//
//        // Назначаем наблюдателя (повара)
//        tablet.addObserver(cook);
//        // Назначаем наблюдателя (официанта)
//        cook.addObserver(waiter);
//
//        // Создаем 4 заказа
//        tablet.createOrder();

//        // Создаем планшет директора
//        DirectorTablet directorTablet = new DirectorTablet();
//        // Вызываем 4 метода, для отбора статистики
//        directorTablet.printAdvertisementProfit();
//        directorTablet.printCookWorkloading();
//        directorTablet.printActiveVideoSet();
//        directorTablet.printArchivedVideoSet();


//        List<Tablet> tablets = new ArrayList<>();
//        tablets.add(new Tablet(1));
//        tablets.add(new Tablet(2));
//        tablets.add(new Tablet(3));
//        tablets.add(new Tablet(4));
//        tablets.add(new Tablet(5));
//
//        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
//        thread.start();

    }
}
