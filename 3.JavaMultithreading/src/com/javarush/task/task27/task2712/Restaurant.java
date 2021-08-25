package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Основной класс ресторана.
 * Данный класс создан для автоматизации работы в ресторане.
 * <p>
 * Задание.
 * Директор ресторана хочет, чтобы:
 * 1) На каждом столике лежал планшет, через который можно было бы сделать заказ;
 * 2) Пока заказ готовится, на планшете показывалась реклама;
 * 3) В конце рабочего дня была возможность посмотреть различную статистику:
 * - загрузки повара;
 * - сумму выручки за заказы;
 * - сумму выручки за показы рекламы.
 * <p>
 * В данной задаче разрабатывается ядро, без UI (User Interface).
 * <p>
 * Что нужно реализовать:
 * 1.1) Созданный посетителем заказ будет автоматически поступать к повару;
 * 1.2) Повар будет готовить его какое-то время и отмечать приготовленным;
 * 1.3) После этого официант будет относить его.
 * <p>
 * 2.1) Подобрать нужные рекламные ролики из списка оплаченных;
 * 2.2) Отображать рекламные ролики во время приготовления заказа;
 * 2.3) Максимизировать прибыль от показа рекламы.
 * <p>
 * 3.1) Подсчитывает статистику;
 * 3.2) Отображает статистику директору.
 */
public class Restaurant {
    // Интервал создания заказа
    private static final int ORDER_CREATING_INTERVAL = 100;

    // Очередь заказов
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();

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

        // Создаем список из 5 планшетов
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(ORDER_QUEUE);
            tablets.add(tablet);
        }

        // Создаем официанта
        Waiter waiter = new Waiter();

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();

        // Создаем 2 потока, делаем их daemon и запускаем их
        Thread firstCookThread = new Thread(firstCook);
        firstCookThread.setDaemon(true);
        firstCookThread.start();

        Thread secondCookThread = new Thread(secondCook);
        secondCookThread.setDaemon(true);
        secondCookThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }

        thread.interrupt();


        // Создаем планшет директора
        DirectorTablet directorTablet = new DirectorTablet();
        // Вызываем 4 метода, для отбора статистики
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}

//Ресторан(22)
//К сожалению, заказы все еще не готовятся параллельно. Вот как работает наш трэд из предыдущего задания.
//Он находит повара, потом находит заказ, отдает заказ повару методом startCookingOrder,
// потом ждет окончания приготовления, и только после этого переходит к следующему заказу.
// Так происходит потому, что все действия внутри одного трэда - последовательные.
// Мы не можем в пределах одного трэда выполнять параллельные процессы.

//Нам нужна стандартная Producer-Consumer реализация.
//RandomOrderGeneratorTask у нас Producer, т.к. производит заказы.
//Cook - это Consumer, т.к. обрабатывает заказы.
//

//1. Перенеси поле-очередь из OrderManager в Restaurant, сделай ее приватной константой.

//2. Добавь поле-очередь LinkedBlockingQueue queue и сеттер в класс Cook,
// сразу после создания повара, используя созданный сеттер, установи ему константу
// из п.1 в качестве значения для созданного поля.

//3. Tablet не должен быть Observable. Убери все зависимости.

//4. В Tablet добавь поле-очередь LinkedBlockingQueue queue,
// создай сеттер для него и установи ссылку на очередь (п.1) при создании планшета.

//5. В Tablet часть логики, которая уведомляет Observer-а, замени на такую, которая добавляет заказ в очередь.
//
//6. Из класса StatisticManager удали сет поваров, его геттер и метод register(Cook cook).


//7. Сделай класс Cook таском (Runnable).
// Перенеси логику из трэда внутри конструктора OrderManager в метод run класса Cook.

//8. Удали класс OrderManager и в методе main исправь зависимость Observer-Observable.

//9. В методе main создай и запусти трэды на основании тасок Cook.
//
//
//Requirements:
//1. В классе Restaurant должно быть создано private final static поле ORDER_QUEUE типа LinkedBlockingQueue.
//2. В классе Cook должно быть создано private поле queue типа LinkedBlockingQueue и сеттер.
//3. В классе Tablet должно быть создано private поле queue типа LinkedBlockingQueue и сеттер.

//4. Класс Tablet не должен быть потомком класса Observable.

//5. Класс Cook должен поддерживать интерфейс Runnable.
//6. Общая логика приготовления заказов и показа рекламы должна быть сохранена.
//7. Класс OrderManager должен быть удален.

