package com.javarush.task.task30.task3003;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * Экономим время
 * 1. Создай Producer и Consumer (См. комментарий к методу main).
 * 2. Создай методы toString, equals и hashCode в классе ShareItem.
 * Для этого в IntelliJ IDEA в теле класса ShareItem выполни:
 * 2.1. Alt+Insert -> toString() -> Enter.
 * 2.2. Alt+Insert -> equals() and hashCode() -> click all 'Next'-s.
 * 2.3. Реализацию методов toString(), equals() и hashCode() оставь такими, какими их сгенерировала IntelliJ IDEA.
 * 3. В Producer и Consumer реализуй метод run так, чтобы вызов метода interrupt прерывал
 * работу consumer и producer трэдов.
 *
 * 4. Реализация метода run для Producer:
 * 4.1. Используя метод offer добавь в очередь 9 ShareItem-ов с такими параметрами: ("ShareItem-N", N),
 * где N - номер элемента от 1 до 9.
 * 4.2. Перед каждым добавлением выведи фразу "Элемент 'ShareItem-N' добавлен". Используй System.out.format.
 * 4.3. Усыпи трэд на 0.1 секунды.
 * 4.4. Если у очереди есть Consumer, не занятый работой, то выведи фразу "Consumer в ожидании!".
 * Просмотри методы интерфейса TransferQueue, там есть нужный метод.
 *
 * 5. Реализация метода run для Consumer:
 * 5.1. Усыпи трэд на 0.45 секунды.
 * 5.2. В бесконечном цикле забери элемент из очереди методом take и выведи в консоль "Processing item.toString()".
 *
 * 6. Сверь вывод с файлом output.txt.
 * 7. Стек-трейс не выводи в консоль.
 * 8. Для вывода любой информации на экран используй System.out.format.
 *
 *
 * Requirements:
 * 1. Создай класс Producer.
 * 2. Создай класс Consumer.
 * 3. В классе ShareItem должны быть созданы методы: toString(), equals(Object) и hashCode().
 * 4. Метод run() класса Producer должен быть реализован согласно условию задачи.
 * 5. Метод run() класса Consumer должен быть реализован согласно условию задачи.
 * 6. Вывод должен совпадать с файлом output.txt.
 */
public class Solution {

    public static void main(String[] args) throws InterruptedException {
        TransferQueue<ShareItem> queue = new LinkedTransferQueue<>();

        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();

        Thread.sleep(1500);

        producer.interrupt();
        consumer.interrupt();
    }

}