package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/**
 * Живем своим умом
 * В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
 * 1. прервать нить, которая бросила исключение.
 * 2. вывести в консоль стек исключений, начиная с самого вложенного.
 *
 * Пример исключения:
 * new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
 *
 * Пример вывода:
 * java.lang.IllegalAccessException: GHI
 * java.lang.RuntimeException: DEF
 * java.lang.Exception: ABC
 *
 *
 * Requirements:
 * 1. Класс Solution должен реализовывать интерфейс Thread.UncaughtExceptionHandler.
 * 2. После вызова uncaughtException нужно прервать нить, которая бросила исключение.
 * 3. Затем, вывести в консоль стек исключений, начиная с самого вложенного исключения.
 * 4. Сообщения должны выводиться в формате "exception class: exception message".
 */

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (t != null) {
            t.interrupt();
        }

        List<String> list = new LinkedList<>();
        while (e != null) {
            list.add(0, e.toString());
            e = e.getCause();
        }

        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        new Solution().uncaughtException(new Thread(),
                new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
